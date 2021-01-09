package com.example.cameraapp.views

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.cameraapp.Dialog.NetworkReceiver
import com.example.cameraapp.Dialog.alertDialogCustom
import com.example.cameraapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.porgress_dialog.view.*


class MainActivity : AppCompatActivity() {

    lateinit var Registro: Button;
    lateinit var Usuario: EditText;
    lateinit var Password: EditText;
    lateinit var forgotPass: Button;
     lateinit var auth: FirebaseAuth;
    lateinit var singIn:Button;
    private lateinit var receiver:  NetworkReceiver


    companion object estaticos{
        const val TAG = "El Email y Password"
        private var wifiConnected = false
        private var mobileConnected = false
        var refreshUI = true
        var userPreferences: String? = null
        const val WIFI = "Wi-Fi"
        const val ANY = "Any"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        Registro = findViewById(R.id.Registrar);
        Usuario = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        forgotPass = findViewById(R.id.forgotPassword)
        singIn = findViewById(R.id.SingIn)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver  =  NetworkReceiver()
        this.registerReceiver(receiver, filter)



    }

    override fun onDestroy() {
        super.onDestroy()
        this.unregisterReceiver(receiver)
    }

    override fun onStart() {
        super.onStart()
       val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this );
        userPreferences = sharedPrefs.getString("listPref","Wi-Fi");
        updateConnectedFlags()
        if(refreshUI){
           loadUI()
        }

    }
    fun updateConnectedFlags(){
        val connectionMessage = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeInfo:NetworkInfo? = connectionMessage.activeNetworkInfo
        if(activeInfo?.isConnected  == true){
            networkStatus(true)
            wifiConnected = activeInfo!!.type == ConnectivityManager.TYPE_WIFI
            mobileConnected = activeInfo!!.type == ConnectivityManager.TYPE_MOBILE
        }else {
            networkStatus(false)
            wifiConnected = false
            mobileConnected = false
        }

        }

    fun loadUI() {
        if (userPreferences == ANY && (wifiConnected || mobileConnected) || userPreferences == WIFI && wifiConnected) {
            // AsyncTask subclass
            networkStatus(true)
        } else {
            networkStatus(false )
        }
    }

    fun networkStatus(internetConnection: Boolean){

        if(internetConnection == false) {
            //Dialog fragment to said to the user that dont have internet
            alertDialogCustom().show(supportFragmentManager, "alertDialogCustom")
            Registro.visibility = (View.GONE)
            Usuario.visibility = (View.GONE)
            Password.visibility = (View.GONE)
            forgotPass.visibility = (View.GONE)
            singIn.visibility = (View.GONE)
        }else {
            alertDialogCustom().dismiss()
            Registro.visibility = (View.VISIBLE)
            Usuario.visibility = (View.VISIBLE)
            Password.visibility = (View.VISIBLE)
            forgotPass.visibility = (View.VISIBLE)
            singIn.visibility = (View.VISIBLE)

        }

    }



    fun Ingresar(view: View) {

        var usuario: String = Usuario.text.toString()
        var password: String = Password.text.toString()

        if (!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(password)) {

            auth.signInWithEmailAndPassword(usuario, password)
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Error en la Autenticacion.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }else{
            Toast.makeText(
                baseContext, "Fallo el inicio de sesión.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    fun Registrarse(view: View) {
        val intent = Intent(this, RegistrarActivity::class.java)
        startActivity(intent)
    }

    fun olvidarContra(view: View) {
       startActivity(Intent(this, forgotPass::class.java))
    }




}



