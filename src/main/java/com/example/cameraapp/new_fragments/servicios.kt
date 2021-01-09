package com.example.cameraapp.new_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cameraapp.R

class servicios : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflater = inflater.inflate(R.layout.fragment_servicios, container, false)
        return inflater
    }

    companion object {
        fun instanceOfClase() : servicios = servicios()
    }
}