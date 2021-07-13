package com.example.hackathon2021.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.hackathon2021.R
import com.example.hackathon2021.databinding.DetailFragmentBinding
import com.example.hackathon2021.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    lateinit var binding: DetailFragmentBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.board = args.board
        getComments()
    }
    private fun observe(){
        viewModel.resGetComments.observe(viewLifecycleOwner, Observer {

        })
    }
    private fun getComments(){
        viewModel.getComments(args.board.id)
    }

}