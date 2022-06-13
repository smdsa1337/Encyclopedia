package com.smdsa.encyclopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smdsa.encyclopedia.adapters.FirstFragment
import com.smdsa.encyclopedia.adapters.SecondFragment
import com.smdsa.encyclopedia.adapters.ThirdFragment
import com.smdsa.encyclopedia.databinding.ActivityNavigationClassBinding

class NavigationClass : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationClassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationBar.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment())
            .commit()
    }

    private val navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.first -> selectedFragment = FirstFragment()
                R.id.second -> selectedFragment = SecondFragment()
                R.id.third -> selectedFragment = ThirdFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
            true
        }
}