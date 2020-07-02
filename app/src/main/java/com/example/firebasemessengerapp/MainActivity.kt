package com.example.firebasemessengerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {
            performRegister()
        }

        already_have_account_text_view.setOnClickListener {
            Log.d("Main Activity", "show login activity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister() {
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        Log.d("Main Activity", "email is " + email)
        Log.d("Main Activity", "password is $password")

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text to email/pass", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener
                Log.d("Main", "Successfully created user with uid ${it.result?.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Main", "FAILED user = ${it.message}")
                Toast.makeText(this, "FAILED user = ${it.message}", Toast.LENGTH_LONG).show()

            }
    }
}
