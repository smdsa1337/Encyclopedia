package com.smdsa.encyclopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smdsa.encyclopedia.RealTimeDB.ReadClass
import com.smdsa.encyclopedia.RealTimeDB.WriteClass
import com.smdsa.encyclopedia.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.createToast.setOnClickListener {
            intent = Intent(this,ToastClass::class.java)
            startActivity(intent)
        }
        binding.bottomNavigation.setOnClickListener {
            intent = Intent(this,NavigationClass::class.java)
            startActivity(intent)
        }
        binding.registrationDB.setOnClickListener {
            intent = Intent(this,RegistrationClass::class.java)
            startActivity(intent)
        }
        binding.readRealTimeDB.setOnClickListener {
            intent = Intent(this, ReadClass::class.java)
            startActivity(intent)
        }
        binding.writeRealTimeDB.setOnClickListener {
            intent = Intent(this,WriteClass::class.java)
            startActivity(intent)
        }
        binding.clicker.setOnClickListener {
            intent = Intent(this, Clicker::class.java)
            startActivity(intent)
        }
        binding.workWithTxt.setOnClickListener {
            intent = Intent(this,WorkWithTXT::class.java)
            startActivity(intent)
        }
        binding.recordMicrophone.setOnClickListener {
            intent = Intent(this, MicrophoneClass::class.java)
            startActivity(intent)
        }
        binding.webSite.setOnClickListener {
            intent = Intent(this, InternetClass::class.java)
            startActivity(intent)
        }
    }
}