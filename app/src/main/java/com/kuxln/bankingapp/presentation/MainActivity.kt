package com.kuxln.bankingapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kuxln.bankingapp.R
import com.kuxln.bankingapp.databinding.ActivityMainBinding
import com.kuxln.bankingapp.presentation.core.ui.setGone
import com.kuxln.bankingapp.presentation.core.ui.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavController()
    }

    fun onDestinationChanged() {
        configureToolbarVisibility()
    }

    private fun setupNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationBar.setupWithNavController(navController)
    }

    private fun configureToolbarVisibility() = with(binding) {
        if (navController.currentDestination?.id == R.id.home_dest || navController.currentDestination?.id == R.id.services_dest) {
            hideToolbarNavigationIcon()
        } else {
            showToolbarNavigationIcon()
        }
    }

    private fun showToolbarNavigationIcon() = with(binding) {
        toolbar.navigationIcon = AppCompatResources.getDrawable(this@MainActivity, R.drawable.ic_24_arrow_back)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun hideToolbarNavigationIcon() = with(binding) {
        toolbar.navigationIcon = null
    }
}