package com.min.listApp.ui.view

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.FragmentManager
import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.min.listApp.R
import com.min.listApp.databinding.ActivityMainBinding
import com.min.listApp.ui.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    //override var presenter: MainConstract.Presenter = MainPresenter(this)

    override fun initLayout() {
        setupNav()

        binding.searchInput.setOnEditorActionListener { textView, actionId, _ ->

            when (actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                //임시로 연결해 놓는다.
//                (foregroundFragment?.presenter as? ListFragmentPresenter)?.let{
//                    it.setCategory("image")
//                    it.searchKakao(keyword = textView.text.toString())
//                }
            }
        }

            return@setOnEditorActionListener true
        }
   }

    //임시로 현재 Fragment를 가져온다.
//    val foregroundFragment: ListFragmentConstract.View? by lazy {
//        return@lazy supportFragmentManager.fragments.get(0).childFragmentManager.fragments.get(0) as? ListFragmentConstract.View
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//        val searchItem: MenuItem = menu.findItem(R.id.action_search)
//        val searchView = searchItem.actionView as SearchView
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupNav() {
        binding.navBottomView.setupWithNavController(navController)
    }
}

class MyNavHostFragment : NavHostFragment() {
    override fun createFragmentNavigator() =
        MyFragmentNavigator(requireContext(), childFragmentManager, id)
}

@Navigator.Name("fragment")
class MyFragmentNavigator(
    context: Context,
    fm: FragmentManager,
    containerId: Int
) : FragmentNavigator(context, fm, containerId) {

    override fun navigate(destination: Destination, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?): NavDestination? {
        val shouldSkip = navOptions?.run {
            popUpTo == destination.id && !isPopUpToInclusive
        } ?: false

        return if (shouldSkip) null else super.navigate(destination, args, navOptions, navigatorExtras)
    }
}