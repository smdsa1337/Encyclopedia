package com.smdsa.encyclopedia.RealTimeDB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.smdsa.encyclopedia.databinding.ActivityWriteClassBinding

class WriteClass : AppCompatActivity() {

    private lateinit var binding: ActivityWriteClassBinding
    val myRef : DatabaseReference = FirebaseDatabase
        .getInstance("https://micro-chel-default-rtdb.europe-west1.firebasedatabase.app")
        .getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.write.setOnClickListener {
            var a = RealTimeDBAdapter()
            if(!binding.first.text.toString().isEmpty() && !binding.second.text.toString().isEmpty() && !binding.third.text.toString().isEmpty()){
                a.first = binding.first.text.toString()
                a.second = binding.second.text.toString()
                a.third = binding.third.text.toString()
                myRef.child("EditText").setValue(a)
            }
            else
                Toast.makeText(this,"Check all EditText, pls", Toast.LENGTH_SHORT).show()

        }
        myRef.child("EditText").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var a = snapshot.getValue(RealTimeDBAdapter::class.java)
                    binding.textViewResult.text = "${a!!.first} ${a!!.second} ${a!!.third}"
                }
                override fun onCancelled(error: DatabaseError) {

                }
            }
        )
    }
}