package com.example.cameraapp.new_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cameraapp.R

class RegistrarV : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflateLayout =  inflater.inflate(R.layout.fragment_registrar_v, container, false)
        return inflateLayout
    }

    companion object {
        fun instanceOfClase() : RegistrarV = RegistrarV()
    }
}