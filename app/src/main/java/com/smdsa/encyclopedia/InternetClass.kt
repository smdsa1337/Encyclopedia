package com.smdsa.encyclopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smdsa.encyclopedia.adapters.MyWebViewClient
import com.smdsa.encyclopedia.databinding.ActivityInternetClassBinding

class InternetClass : AppCompatActivity() {

    private lateinit var binding: ActivityInternetClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webViewCon.settings.javaScriptEnabled = true
        binding.webViewCon.loadUrl("https://github.com/smdsa1337/Encyclopedia")
        binding.webViewCon.webViewClient = MyWebViewClient()
    }

    override fun onBackPressed() {
        if (binding.webViewCon.canGoBack())
            binding.webViewCon.goBack()
        else
            super.onBackPressed()
    }
}



