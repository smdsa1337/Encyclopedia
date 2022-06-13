package com.smdsa.encyclopedia

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smdsa.encyclopedia.databinding.ActivityToastClassBinding

class ToastClass : AppCompatActivity() {

    private lateinit var binding: ActivityToastClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.createToast.setOnClickListener {
            var size = Toast.LENGTH_LONG
            var text = "Made long (auto)"
            if(binding.Long.isChecked){
                size = Toast.LENGTH_LONG
                text = "Made long"
            }
            else if(binding.Short.isChecked){
                size = Toast.LENGTH_SHORT
                text = "Made short"
            }
            Toast.makeText(this,text,size).show()
        }
    }
}