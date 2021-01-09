package com.example.cameraapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.cameraapp.views.MainActivity
import com.example.cameraapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegistrarActivity : AppCompatActivity() {

    lateinit var Nombre: EditText;
    lateinit var Apellido: EditText;
    lateinit var UsuarioRegistro: EditText;
    lateinit var PasswordRegistro: EditText;
    lateinit var auth: FirebaseAuth
    lateinit var BarraProgreso: ProgressBar;
    lateinit var dbReference : DatabaseReference;
    lateinit var database: FirebaseDatabase;

    companion object {
        const val TAG = "NewUser"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registrar)

         UsuarioRegistro = findViewById(R.id.UsuarioRegistro);
         PasswordRegistro = findViewById(R.id.PasswordRegistro);
         Nombre = findViewById(R.id.Nombre);
        Apellido = findViewById(R.id.Apellido);
        BarraProgreso = findViewById(R.id.ProgressBar)
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        dbReference = database.reference.child("Usuarios");



    }

     fun crearUsuarios(view: View) {


        var nombre = Nombre.text.toString();
        var apellido = Apellido.text.toString();
        var usuario = UsuarioRegistro.text.toString();
        var password = PasswordRegistro.text.toString();

        if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(password)){

            BarraProgreso.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(usuario,password)
                .addOnCompleteListener(this){task ->

                    if(task.isSuccessful){
                        val user: FirebaseUser? = auth.currentUser
                        verifyEmail(user)

                        val usuarioDB = dbReference.child(user?.uid!!)
                        usuarioDB.child("Nombre").setValue(nombre);
                        usuarioDB.child("Apellido").setValue(apellido);
                        usuarioDB.child("Email").setValue(usuario);
                        moverAlMain()
                    }else{
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }


        }

    }// final del crearUsuarios

    fun moverAlMain(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun verifyEmail(usuario: FirebaseUser?){

        if (usuario != null) {
            usuario?.sendEmailVerification()
                ?.addOnCompleteListener(this){ task ->
                    if (task.isComplete){
                        Toast.makeText(this,"Email Enviado correctamente",Toast.LENGTH_LONG).show()
                    }else{

                        Toast.makeText(this,"Error al enviar correo",Toast.LENGTH_LONG).show()
                    }

                }
        }


    }



}