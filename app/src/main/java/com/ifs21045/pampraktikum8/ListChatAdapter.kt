// Mendefinisikan paket dari kelas ini
package com.ifs21045.pampraktikum8
// Mengimpor kelas-kelas yang diperlukan dari library Android
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21045.pampraktikum8.databinding.ItemRowChatBinding

// Mendefinisikan kelas ListTyrannosaurusAdapter yang merupakan turunan dari RecyclerView.Adapter
class ListChatAdapter(private val listChat: ArrayList<HomeFragment.Chat>) :
    RecyclerView.Adapter<ListChatAdapter.ListViewHolder>() {

    // Mendeklarasikan lateinit property untuk menyimpan callback onClick
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Metode untuk mengatur callback onClick
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Override metode onCreateViewHolder untuk membuat ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        // Membuat binding untuk tampilan item daftar tyrannosaurus
        val binding = ItemRowChatBinding.inflate(LayoutInflater.from(viewGroup.context),
            viewGroup, false)
        // Mengembalikan ViewHolder baru
        return ListViewHolder(binding)
    }

    // Override metode onBindViewHolder untuk mengikat data ke ViewHolder
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // Mendapatkan objek Tyrannosaurus dari posisi yang diberikan
        val chat = listChat[position]
        // Mengatur gambar dan teks pada tampilan item
        holder.binding.ivItemChat.setImageResource(R.drawable.chat)
        holder.binding.tvItemChat.text = chat.name
        // Menetapkan listener onClick untuk item

    }

    // Override metode getItemCount untuk mengembalikan jumlah item dalam daftar
    override fun getItemCount(): Int = listChat.size

    // Mendefinisikan kelas inner ViewHolder
    class ListViewHolder(var binding: ItemRowChatBinding) :
        RecyclerView.ViewHolder(binding.root)

    // Interface untuk menangani klik item dalam RecyclerView
    interface OnItemClickCallback {
        fun onItemClicked(data: Chat)
    }
}
