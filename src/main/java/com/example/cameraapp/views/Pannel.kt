package com.example.cameraapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cameraapp.R
import com.example.cameraapp.new_fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_pannel.*

class Pannel : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(completeControlPannel)
val navigationView: BottomNavigationView  = findViewById(R.id.botom_nav)

        navigationView.setOnNavigationItemSelectedListener { menuItem ->

            when(menuItem.itemId){

                idHome ->{
                    val correspondingFragment = home.newInstance()
                    openFragment(correspondingFragment)
                    true
                }

                idVisitas ->{
                    val correspondingFragment = VisitasFragment.newInstance()
                    openFragment(correspondingFragment)
                    true
                }

                idRegisterVisits ->{
                    val correspondingFragment = RegistrarV.instanceOfClase()
                    openFragment(correspondingFragment)
                    true
                }
                idMyInf ->{
                    val correspondingFragment = MyInfo.instanceOfClase()
                    openFragment(correspondingFragment)
                    true
                }

                idServices ->{
                    val correspondingFragment =  servicios.instanceOfClase()
                    openFragment(correspondingFragment)
                    true
                }


                else -> false
            }
        }

         botom_nav.selectedItemId = R.id.pannel
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


    companion object {

        val idHome = R.id.pannel
        val completeControlPannel = R.layout.activity_pannel
        val idVisitas = R.id.visitas
        val idRegisterVisits = R.id.RegistrarV
        val idMyInf = R.id.myInf
        val idServices = R.id.Services

    }

}