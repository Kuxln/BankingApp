package com.kuxln.bankingapp.presentation.auth.signin

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
import com.kuxln.bankingapp.databinding.FragmentSingInBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSingInBinding>(R.layout.fragment_sing_in) {

    private val viewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSingInBinding.bind(view)

        binding.buttonSignIn.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.onSignIn(email, password)
        }

        binding.buttonToSignUp.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInDestToSignUpFragment()
            findNavController().navigate(action)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { isSuccess ->
                    if (isSuccess){
                        val action = SignInFragmentDirections.actionSignInDestToHomeDest()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}