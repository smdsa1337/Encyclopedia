package com.smdsa.encyclopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smdsa.encyclopedia.adapters.SharedPreference
import com.smdsa.encyclopedia.databinding.ActivityClickerBinding

class Clicker : AppCompatActivity() {

    private var count: Int = 0
    private lateinit var binding: ActivityClickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreference : SharedPreference =  SharedPreference(this@Clicker)
        count = sharedPreference.getValueInt("count")
        binding.textView.text = "Your score: $count"
        binding.createToast.setOnClickListener {
            count++
            binding.textView.text = "Your score: $count"
            sharedPreference.save("count",count)
        }
    }
}