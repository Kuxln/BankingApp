package com.kuxln.bankingapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentMainBinding
import com.kuxln.bankingapp.presentation.core.BaseFragment
import dagger.hilt.EntryPoint

@EntryPoint
class HomeFragment: BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)
    }
}