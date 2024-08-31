package com.kuxln.bankingapp.presentation.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentHomeBinding
import com.kuxln.bankingapp.databinding.FragmentSignUpBinding
import com.kuxln.bankingapp.databinding.FragmentSingInBinding
import com.kuxln.bankingapp.presentation.auth.signin.SignInFragmentDirections
import com.kuxln.bankingapp.presentation.auth.signin.SignInViewModel
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSignUpBinding.bind(view)

        binding.buttonSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.onSignUp(email, password)
        }

        binding.buttonToSignIn.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpDestToSignInFragment()
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { isSuccess ->
                    if (isSuccess){
                        val action = SignUpFragmentDirections.actionSignUpDestToHomeDest()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}