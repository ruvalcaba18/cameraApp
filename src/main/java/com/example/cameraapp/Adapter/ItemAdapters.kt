package com.example.cameraapp.Adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.cameraapp.R


class ItemAdapters(var context: Context,var arrayList: ArrayList<itemList>): BaseAdapter() {


    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
       return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
     return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View  = View.inflate(context,R.layout.card_view_pannel,null)
        val card: CardView = view.findViewById(R.id.cardview)
        val icons: ImageView = view.findViewById(R.id.imageAceptV)
        val titles:TextView = view.findViewById(R.id.title)
        val details:TextView = view.findViewById(R.id.details)
        val listItems: itemList = arrayList.get(position)

        icons.setImageResource(listItems.icons!!)
        titles.text = listItems.titles
        details.text = listItems.details


        when (position){
            0 -> icons.visibility = View.INVISIBLE
                1,2-> { card.setCardBackgroundColor(Color.parseColor("#b71c1c"))}
            else -> {   card.setCardBackgroundColor(Color.parseColor("#0097A7"))}

        }





        return view
    }

}