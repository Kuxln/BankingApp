package com.kuxln.bankingapp.presentation.services.aboutclient

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.data.room.entity.ClientEntity
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AboutClientFragment :
    BaseFragment<FragmentAboutClientBinding>(R.layout.fragment_about_client) {

    private val viewModel: AboutClientViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAboutClientBinding.bind(view)

        getClientData()
    }

    private fun setupViews(clientEntity: ClientEntity) = with(binding) {
        val login = SpannableStringBuilder(clientEntity.login)
        val phoneNumber = SpannableStringBuilder(clientEntity.phoneNumber)
        val lastName = SpannableStringBuilder(clientEntity.lastName)
        val firstName = SpannableStringBuilder(clientEntity.firstName)
        val address = SpannableStringBuilder(clientEntity.address)
        val creditLimit = SpannableStringBuilder(clientEntity.creditLimit.toString())
        val postIndex = SpannableStringBuilder((clientEntity.postIndex ?: 0).toString())

        etLogin.text = login
        etPhoneNumber.text = phoneNumber
        etLastName.text = lastName
        etFirstName.text = firstName
        etAddress.text = address
        etCreditLimit.text = creditLimit
        etPostIndex.text = postIndex
    }

    private fun setupListeners() = with(binding) {
        buttonUpdateProfile.setOnClickListener {
            val login = etLogin.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val lastName = etLastName.text.toString()
            val firstName = etFirstName.text.toString()
            val address = etAddress.text.toString()
            val creditLimit = etCreditLimit.text.toString().toInt()
            val postIndex = etPostIndex.text.toString().toInt()

            viewModel.onUpdate(
                login,
                phoneNumber,
                lastName,
                firstName,
                address,
                creditLimit,
                postIndex,
            )
        }
    }

    private fun getClientData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiState.collect { clientEntity ->
                    clientEntity?.let {
                        setupViews(clientEntity)
                        setupListeners()
                    }
                }
            }
        }
    }
}