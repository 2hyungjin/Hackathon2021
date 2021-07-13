package com.example.hackathon2021.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathon2021.viewmodel.MainViewModel
import com.example.hackathon2021.R
import com.example.hackathon2021.adapter.BoardListAdapter
import com.example.hackathon2021.data.Board
import com.example.hackathon2021.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: MainFragmentBinding
    private val args: MainFragmentArgs by navArgs()
    lateinit var boardListAdapter: BoardListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        boardListAdapter = BoardListAdapter {
            navigateToDetail(it)
        }
        binding.school = args.school
        binding.fabNavigatePostMainFragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_postFragment)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter
        }
    }

    private fun navigateToDetail(board: Board) {
        findNavController().nav
    }


}