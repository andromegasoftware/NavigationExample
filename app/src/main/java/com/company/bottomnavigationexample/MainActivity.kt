package com.company.bottomnavigationexample

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var mnavigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mnavigationView = nav_view

        drawerLayout = drawer_Layout
        bottomNav = bottom_nav
        navController = findNavController(R.id.fragment_host)
        appBarConfig = AppBarConfiguration(setOf(
            R.id.nav_menu_home,
            R.id.nav_menu_messages,
            R.id.nav_menu_notification
        ))

        setupActionBarWithNavController(navController, appBarConfig)
        bottomNav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(nav_view, navController)

        mnavigationView.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_about -> {
                Toast.makeText(applicationContext, "About Menu is Clicked", Toast.LENGTH_LONG ).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.navigation_help -> {
                Toast.makeText(applicationContext, "Help Menu is Clicked", Toast.LENGTH_LONG ).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.main_menu_edit ->{
                Toast.makeText(applicationContext, "Edit Menu is Clicked", Toast.LENGTH_LONG ).show()
            }
            R.id.main_menu_delete ->{
                Toast.makeText(applicationContext, "Delete Menu is Clicked", Toast.LENGTH_LONG ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}