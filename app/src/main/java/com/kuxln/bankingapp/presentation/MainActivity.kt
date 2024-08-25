package com.kuxln.bankingapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.ActivityMainBinding
import com.kuxln.bankingapp.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, HomeFragment(), HomeFragment::class.java.name)
            .commit()

        binding.bottomNavigationBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {

                }

                R.id.services -> {

                }
            }
            true
        }
    }
}