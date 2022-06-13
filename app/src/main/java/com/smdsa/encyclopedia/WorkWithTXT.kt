package com.smdsa.encyclopedia

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.smdsa.encyclopedia.databinding.ActivityWorkWithTxtBinding
import java.io.File
import java.io.FileInputStream
import java.lang.Exception


class WorkWithTXT : AppCompatActivity() {

    private lateinit var binding: ActivityWorkWithTxtBinding
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkWithTxtBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 112)
        }
        binding.createTxt.setOnClickListener {
            text = "Original text"
            if(!binding.textTXT.text.isEmpty())
                text = binding.textTXT.text.toString()
            val path = this.getExternalFilesDir(null)
            val letDirectory = File(path, "FileTXT")
            letDirectory.mkdirs()
            val file = File(letDirectory, "File.txt")
            file.writeText(text)
            Toast.makeText(this,"File is created",Toast.LENGTH_SHORT).show()
        }
        binding.readTxt.setOnClickListener{
            try{
                val path = this.getExternalFilesDir(null)
                val letDirectory = File(path, "FileTXT")
                val file = File(letDirectory, "File.txt")
                val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }
                Toast.makeText(this,"Text from txt file = $inputAsString" ,Toast.LENGTH_SHORT).show()
            }
            catch (exception : Exception){
                Toast.makeText(this,"First create txt file",Toast.LENGTH_SHORT).show()
            }
        }
    }
}