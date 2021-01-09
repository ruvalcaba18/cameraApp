package com.example.cameraapp.new_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cameraapp.R


class VisitasFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val visitsLayout = inflater.inflate(R.layout.fragment_visitas, container, false)
        return visitsLayout
    }

    companion object {
       fun newInstance(): VisitasFragment = VisitasFragment()
    }
}