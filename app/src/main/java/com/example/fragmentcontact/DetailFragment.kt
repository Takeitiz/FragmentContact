package com.example.fragmentcontact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {
    lateinit var ID: TextView
    lateinit var NAME: TextView
    lateinit var NUMBER: TextView
    lateinit var EMAIL: TextView
    lateinit var THUMB: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)

        ID = view.findViewById(R.id.idTextView)
        NAME = view.findViewById(R.id.nameTextView)
        NUMBER = view.findViewById(R.id.numberTextView)
        EMAIL = view.findViewById(R.id.emailTextView)
        THUMB = view.findViewById(R.id.thumbImageView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ID = view.findViewById(R.id.idTextView)
        NAME = view.findViewById(R.id.nameTextView)
        NUMBER = view.findViewById(R.id.numberTextView)
        EMAIL = view.findViewById(R.id.emailTextView)
        THUMB = view.findViewById(R.id.thumbImageView)
    }

    fun UpdateContent(thumb: Int, id: String, name: String, number: String, email: String) {
        THUMB.setImageResource(thumb)
        ID.text = "ID: " + id
        NAME.text = "Tên: " + name
        NUMBER.text = "Phone number: " + number
        EMAIL.text = "Email: " + email
    }
}