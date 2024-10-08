package com.kuxln.bankingapp.presentation

import android.os.Bundle
import android.view.View
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
        configureBottomNavVisibility()
    }

    private fun setupNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationBar.setupWithNavController(navController)
    }

    private fun configureToolbarVisibility() {
        when (navController.currentDestination?.id) {
            R.id.home_dest -> hideToolbarNavigationIcon()
            R.id.services_dest -> hideToolbarNavigationIcon()
            R.id.sign_in_dest -> hideToolbarNavigationIcon()
            R.id.sign_up_dest -> hideToolbarNavigationIcon()
            else -> showToolbarNavigationIcon()
        }
    }

    private fun configureBottomNavVisibility() {
        if (navController.currentDestination?.id == R.id.sign_in_dest || navController.currentDestination?.id == R.id.sign_up_dest) {
            hideBottomNav()
        } else {
            showBottomNav()
        }
    }

    private fun showToolbarNavigationIcon() = with(binding) {
        toolbar.navigationIcon =
            AppCompatResources.getDrawable(this@MainActivity, R.drawable.ic_24_arrow_back)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showBottomNav() = with(binding) {
        bottomNavigationBar.visibility = View.VISIBLE
    }

    private fun hideToolbarNavigationIcon() = with(binding) {
        toolbar.navigationIcon = null
    }

    private fun hideBottomNav() = with(binding) {
        bottomNavigationBar.visibility = View.GONE
    }
}