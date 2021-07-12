package com.example.hackathon2021.view.fragment

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hackathon2021.R
import com.example.hackathon2021.data.Account
import com.example.hackathon2021.databinding.LoginFragmentBinding
import com.example.hackathon2021.util.mApplication
import com.example.hackathon2021.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    lateinit var binding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        binding.btnSignUpLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpSchoolFragment)
        }
        binding.btnLoginLoginFragment.setOnClickListener {
            login()
        }
    }

    private fun observe() {
        viewModel.loginRes.observe(viewLifecycleOwner, Observer {
            mApplication.prefs.token = it.authToken
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        })
    }

    private fun login() {
        val id = binding.edtIdLoginFragment.text.toString()
        val pw = binding.edtPwLoginFragment.text.toString()
        viewModel.login(Account(id, pw))
    }
}