package com.kuxln.bankingapp.presentation.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kuxln.bankingapp.presentation.MainActivity

abstract class BaseFragment<T: ViewBinding>(
    layout: Int
) : Fragment(layout) {

    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as MainActivity).onDestinationChanged()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}