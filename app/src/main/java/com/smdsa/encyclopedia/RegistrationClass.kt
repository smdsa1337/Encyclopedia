package com.smdsa.encyclopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.smdsa.encyclopedia.databinding.ActivityRegistrationClassBinding

class RegistrationClass : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationClassBinding
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.registration.setOnClickListener {
            if(!binding.login.text.toString().isEmpty() && !binding.password.text.toString().isEmpty())
                signUp(binding.login.text.toString(),binding.password.text.toString())
            else
                Toast.makeText(this,"You don`t type login or password", Toast.LENGTH_LONG).show()
        }
    }

    private fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}