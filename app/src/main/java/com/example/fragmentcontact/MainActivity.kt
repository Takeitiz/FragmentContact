package com.example.fragmentcontact

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val listFragment = ListFragment()
    val detailFragment = DetailFragment()
    val addFragment = AddFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, addFragment, "ADD")
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, detailFragment, "DETAIL")
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, listFragment, "LIST")
            .commit()

    }

    fun UpdateDetail(thumb: Int, id: String, name : String, number: String, email: String) {
        detailFragment.UpdateContent(thumb, id, name, number, email)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }
    fun CallAddContact() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, addFragment)
            .addToBackStack(null)
            .commit()
    }

    fun AddContact(contact: Items) {
        listFragment.danhba.add(contact)
    }

}
