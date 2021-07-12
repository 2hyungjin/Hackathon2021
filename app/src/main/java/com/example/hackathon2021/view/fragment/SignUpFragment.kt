package com.example.hackathon2021.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.hackathon2021.R
import com.example.hackathon2021.data.School
import com.example.hackathon2021.databinding.SignUpFragmentBinding
import com.example.hackathon2021.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {
    private val args: SignUpFragmentArgs by navArgs()
    private val viewModel: SignUpViewModel by activityViewModels()
    lateinit var binding: SignUpFragmentBinding
    private lateinit var school: School

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        school = args.school
        binding.school = school

    }
}