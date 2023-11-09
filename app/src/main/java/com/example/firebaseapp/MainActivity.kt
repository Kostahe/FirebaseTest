package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)

        database = Firebase.database.reference

        // Writing custom objects to firebase
        val user1 = User("Jack", "123")

        database.child("Users").setValue(user1)

        val pe = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 = snapshot.getValue<User>()
                textView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        database.child("Users").addValueEventListener(pe)

    }
}