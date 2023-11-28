package com.example.fragmentcontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val listFragment = ListFragment()
    val detailFragment = DetailFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, detailFragment, "DETAIL")
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, listFragment)
            .commit()
    }

    fun UpdateDetail(thumb: Int, id: String, name : String, number: String, email: String) {
        (supportFragmentManager.findFragmentByTag("DETAIL") as DetailFragment)
            .UpdateContent(thumb, id, name, number, email)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }

}