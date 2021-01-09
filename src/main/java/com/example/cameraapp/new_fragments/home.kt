package com.example.cameraapp.new_fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.example.cameraapp.R
import com.example.cameraapp.Adapter.ItemAdapters
import com.example.cameraapp.Adapter.itemList

class home : Fragment(), AdapterView.OnItemClickListener {

    private var lista: ArrayList<itemList>? = null
    private var gridView: GridView? = null
    private var adaptador: ItemAdapters? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val homeView =  inflater.inflate(R.layout.fragment_home, container, false)
         gridView = homeView.findViewById(R.id.my_grid_view_list)
        lista = ArrayList()
        lista = setData()
        adaptador = ItemAdapters(activity?.applicationContext!!, lista!!)
        gridView?.adapter = adaptador
        gridView?.onItemClickListener = this
        return homeView
    }



    private fun setData():ArrayList<itemList>{
        var arrayList:ArrayList<itemList> = ArrayList()
        arrayList.add(itemList(0,"Privada Rincon del Mar","Licencia Activa \n vencimiento: 29 de Abril 2022"))
        arrayList.add(itemList(R.drawable.negar,"No recibo Personas","Presioname para cambiar de estado"))
        arrayList.add(itemList(R.drawable.botonvisitas,"No recibo Visitas","Presioname para cambiar de estado"))
        arrayList.add(itemList(R.drawable.camaras,"Acceso a camaras","Presione para acceder a camaras"))
        arrayList.add(itemList(0,"Comunicación",""))
        arrayList.add(itemList(0,"Boletin",""))
        arrayList.add(itemList(0,"Acceso vehícular",""))
        arrayList.add(itemList(0,"Usuarios",""))
        arrayList.add(itemList(0,"Botón de pánico",""))


        return arrayList
    }

    companion object {
        fun newInstance() : home = home()
    }



    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {





    }

}