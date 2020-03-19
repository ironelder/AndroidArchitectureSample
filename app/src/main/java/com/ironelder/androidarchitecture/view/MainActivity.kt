package com.ironelder.androidarchitecture.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ironelder.androidarchitecture.R
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.databinding.ActivityMainBinding
import com.ironelder.androidarchitecture.view.base.BaseActivity

class MainActivity : AppCompatActivity(R.layout.activity_main){
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

//    override val presenter = MainPresenter(NetworkUseCase())

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNav()
    }

//    override fun onDataChanged(result: List<ListItem>?) {
//        Log.d(
//            "ironelderLog",
//            "result = ${result.isNullOrEmpty().toString()} , itemSize = ${result?.size}"
//        )
////        binding.items = result
//    }

//    override fun showErrorMessage(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun showLoading() {
////        pb_loading.visibility = View.VISIBLE
//    }
//
//    override fun hideLoading() {
////        pb_loading.visibility = View.GONE
//    }
//
//    override fun initializedView(savedInstanceState: Bundle?) {
////        Log.d("ironelderLog", "initializedView ")
////        with(binding.rvSearchList){
////            adapter = SearchListAdapter()
////        }
////        Log.d("ironelderLog", "initializedView searchData")
////        presenter.searchData("blog", "test")
//    }

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
        findViewById<BottomNavigationView>(R.id.nav_bottom_view).visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        findViewById<BottomNavigationView>(R.id.nav_bottom_view).visibility = View.GONE
    }
}