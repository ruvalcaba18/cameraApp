package com.example.cameraapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.cameraapp.R
import com.google.firebase.auth.FirebaseAuth

class forgotPass : AppCompatActivity() {

    lateinit var email: EditText;
    lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        email = findViewById(R.id.recuperarContra)
        auth = FirebaseAuth.getInstance()

    }

    fun send(view: View) {

        val obtenerEmail = email.text.toString()

        if ( !TextUtils.isEmpty(obtenerEmail)){
            auth.sendPasswordResetEmail(obtenerEmail)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))

                    }else{

                        Toast.makeText(baseContext, "Error al enviar el email.",
                            Toast.LENGTH_SHORT).show()
                    }
                }

        }else{

            Toast.makeText(baseContext, "No deje campos en blanco.",
                Toast.LENGTH_SHORT).show()
        }


    }


}

