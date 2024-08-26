package com.kuxln.bankingapp.presentation.services.aboutclient

import android.os.Bundle
import android.view.View
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentAboutClientBinding
import com.kuxln.bankingapp.presentation.core.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutClientFragment : BaseFragment<FragmentAboutClientBinding>(R.layout.fragment_about_client) {

//    private val viewModel: *** by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAboutClientBinding.bind(view)
    }
}