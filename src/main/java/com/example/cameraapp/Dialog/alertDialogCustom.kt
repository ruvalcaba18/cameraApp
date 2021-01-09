package com.example.cameraapp.Dialog

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.cameraapp.R
import kotlinx.android.synthetic.main.porgress_dialog.*
import kotlinx.android.synthetic.main.porgress_dialog.view.*

class alertDialogCustom: DialogFragment(){

    companion object estaticos{
        const val titulo = "Mensaje"
        const val mssg = "Porfavor mantengase conectado a internet para un mejor uso."
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootView: View = inflater.inflate(R.layout.porgress_dialog,container,false)
        rootView.settings.setOnClickListener{
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent);
        }
        rootView.Cancelar.setOnClickListener{
            dismiss()
        }
        rootView.Title.text = estaticos.titulo
        rootView.mensaje.text = estaticos.mssg
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.rounded_edittext_corners);

        return rootView
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}



