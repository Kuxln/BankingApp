package com.kuxln.bankingapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.ActivityMainBinding
import com.kuxln.bankingapp.presentation.home.HomeFragment
import com.kuxln.bankingapp.presentation.services.ServicesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeFragment = HomeFragment()
        val servicesFragment = ServicesFragment()
        showFragment(homeFragment)

        binding.bottomNavigationBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    showFragment(homeFragment)
                }

                R.id.services -> {
                    showFragment(servicesFragment)
                }
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment, fragment::class.java.name)
            .show(fragment)
            .commit()
    }
}