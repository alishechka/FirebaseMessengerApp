package com.example.firebasemessengerapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

private const val TAG = "Login Activity"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()
            Log.d(TAG, "LOGIN ATTEMPT $email / $password")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    Log.d(TAG, "SIGNIN CORRECT")
                }
                .addOnFailureListener {
                    Log.d(TAG, "SIGNIN FAILED")
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
        }

        back_to_register_textview.setOnClickListener {
            finish()
        }


    }
}

