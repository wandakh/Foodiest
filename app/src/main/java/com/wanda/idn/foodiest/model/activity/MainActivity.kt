package com.wanda.idn.foodiest.model.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wanda.idn.foodiest.R
import com.wanda.idn.foodiest.databinding.ActivityMainBinding
import com.wanda.idn.foodiest.model.fragment.BreakfastFragment
import com.wanda.idn.foodiest.model.fragment.DesserFragment
import com.wanda.idn.foodiest.model.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icBreakfast -> setCurrentFragment(BreakfastFragment())
                R.id.icVegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.icDessert -> setCurrentFragment(DesserFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Flmain, fragment)
            commit()
        }

    }
}
