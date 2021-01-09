package com.example.cameraapp.new_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cameraapp.R

class MyInfo : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflater = inflater.inflate(R.layout.fragment_my_info, container, false)
        return inflater
    }

    companion object {
        fun instanceOfClase() : MyInfo = MyInfo()

    }
}