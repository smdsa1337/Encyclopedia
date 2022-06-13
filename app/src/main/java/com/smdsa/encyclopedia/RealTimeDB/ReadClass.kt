package com.smdsa.encyclopedia.RealTimeDB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import com.smdsa.encyclopedia.databinding.ActivityReadClassBinding

class ReadClass : AppCompatActivity() {

    private lateinit var binding: ActivityReadClassBinding
    val myRef : DatabaseReference = FirebaseDatabase
        .getInstance("https://micro-chel-default-rtdb.europe-west1.firebasedatabase.app")
        .getReference()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myRef.child("HelloText").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var a = snapshot.getValue(RealTimeDBAdapter::class.java)
                    binding.textMiddle.text = "${a!!.first} ${a!!.second} ${a!!.third}"
                }
                override fun onCancelled(error: DatabaseError) {

                }
            }
        )
    }
}