package com.example.cameraapp.Dialog

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.example.cameraapp.R
import com.example.cameraapp.views.MainActivity.estaticos.ANY
import com.example.cameraapp.views.MainActivity.estaticos.WIFI
import com.example.cameraapp.views.MainActivity.estaticos.refreshUI
import com.example.cameraapp.views.MainActivity.estaticos.userPreferences

class NetworkReceiver: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        val conn  = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
        val networkInfo: NetworkInfo? = conn.activeNetworkInfo

        if(WIFI == userPreferences && networkInfo?.type == ConnectivityManager.TYPE_WIFI ){
            refreshUI = true
            Toast.makeText(context, R.string.wifi_connected,Toast.LENGTH_LONG).show()
        }else if (ANY == userPreferences && networkInfo != null) {
            refreshUI = true

        } else {
            refreshUI = false
            Toast.makeText(context, R.string.lost_connection, Toast.LENGTH_SHORT).show()
        }


    }


}