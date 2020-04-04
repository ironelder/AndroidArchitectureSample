package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ironelder.androidarchitecture.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar_home))
        setupNav()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        supportActionBar?.title = null

        return super.onCreateOptionsMenu(menu)
    }

    private fun setupNav() {
        findViewById<BottomNavigationView>(R.id.nav_bottom_view)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        findViewById<Toolbar>(R.id.toolbar_home).visibility = View.VISIBLE
        findViewById<BottomNavigationView>(R.id.nav_bottom_view).visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        findViewById<Toolbar>(R.id.toolbar_home).visibility = View.GONE
        findViewById<BottomNavigationView>(R.id.nav_bottom_view).visibility = View.GONE
    }
}