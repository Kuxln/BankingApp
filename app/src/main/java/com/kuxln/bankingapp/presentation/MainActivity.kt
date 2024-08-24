package com.kuxln.bankingapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.FragmentMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.fragment_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}