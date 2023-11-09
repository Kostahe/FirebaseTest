package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView

        val database = Firebase.firestore

        val usersCollection = database.collection("Users")

        val user1 = hashMapOf(
            "name" to "jack",
            "last" to "reacher",
            "bord" to "1992"
        )

        val user2 = hashMapOf(
            "name" to "john",
            "last" to "travolta",
            "bord" to "1982"
        )

        // Adding Documents to Collection
        usersCollection.document("user1").set(user1)
        usersCollection.document("user2").set(user2)


    }
}