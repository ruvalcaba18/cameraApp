package com.example.cameraapp.Adapter

class itemList {

    var icons: Int? = 0
    var titles: String? = null
    var details: String? = null


    constructor(icons: Int?, titles: String?, details:String?) {
        this.icons = icons
        this.details = details
        this.titles = titles
    }
}