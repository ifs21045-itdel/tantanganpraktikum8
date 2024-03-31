package com.ifs21045.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21045.pampraktikum8.databinding.FragmentHomeBinding

// Mendefinisikan kelas HomeFragment sebagai turunan dari kelas Fragment
class HomeFragment : Fragment() {

    // Mendeklarasikan variabel binding dengan tipe FragmentHomeBinding
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Membuat binding dari tampilan fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inisialisasi RecyclerView
        val recyclerView = binding.tvItemChat
        // Mengatur layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Membuat data untuk RecyclerView
        val data = arrayListOf<Chat>()
        for (i in 0..10) {
            data.add(Chat("John Doe $i", "Hi there! How are you?", "10:00"))
        }

        // Membuat adapter dan menetapkannya ke RecyclerView
        val adapter = ListChatAdapter(data)
        recyclerView.adapter = adapter

        // Mengembalikan tampilan fragment
        return binding.root
    }

    // Membuat kelas data Chat
    data class Chat(
        val name: String,
        val message: String,
        val time: String
    )
}