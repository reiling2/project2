package com.example.gg3

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.gg3.com.example.gg3.ui.BannerAdapter
import com.example.gg3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Инициализация нового Toolbar4
        val toolbar4 = findViewById<Toolbar>(R.id.toolbar4)
        setSupportActionBar(toolbar4)

        // Инициализация ViewPager2
        val viewPager: ViewPager2 = findViewById(R.id.viewPagerBanner)
        val images = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        )
        viewPager.adapter = BannerAdapter(images)

        // Инициализация Navigation
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Работа с кастомными элементами в NavigationView
        val headerView: View = navView.getHeaderView(0)
        val avatarButton = headerView.findViewById<ImageButton>(R.id.avatar)
        val customText = headerView.findViewById<TextView>(R.id.custom_text)
        val customButton = headerView.findViewById<Button>(R.id.custom_button)

        // Установка обработчиков событий
        avatarButton.setOnClickListener {
            Toast.makeText(this, "Аватар нажат", Toast.LENGTH_SHORT).show()
        }

        customText.setOnClickListener {
            Toast.makeText(this, "Текст нажат", Toast.LENGTH_SHORT).show()
        }

        customButton.setOnClickListener {
            Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
