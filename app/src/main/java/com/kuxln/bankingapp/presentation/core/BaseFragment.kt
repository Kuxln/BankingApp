package com.kuxln.bankingapp.presentation.core

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T: ViewBinding>(
    layout: Int
) : Fragment(layout) {
    protected lateinit var binding: T
}