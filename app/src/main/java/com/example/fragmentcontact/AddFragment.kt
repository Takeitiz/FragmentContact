package com.example.fragmentcontact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddFragment : Fragment() {

    lateinit var idEdit : EditText
    lateinit var nameEdit : EditText
    lateinit var numberEdit : EditText
    lateinit var emailEdit : EditText
    lateinit var buttonAdd : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idEdit = view.findViewById(R.id.idEditText)
        nameEdit = view.findViewById(R.id.nameEditText)
        numberEdit = view.findViewById(R.id.numberEditText)
        emailEdit = view.findViewById(R.id.emailEditText)
        buttonAdd = view.findViewById(R.id.button)

        buttonAdd.setOnClickListener {
            if (idEdit.text.isNotBlank()&&nameEdit.text.isNotBlank()&&numberEdit.text.isNotBlank()&&emailEdit.text.isNotBlank()) {
                Toast.makeText(context, "Add Contact Successfully!", Toast.LENGTH_SHORT).show()
                val contact = Items(resources.getIdentifier(
                    "drawable/${nameEdit.text.toString().firstOrNull()?.lowercase()}",
                    null,
                    view.context.packageName
                )
                , idEdit.text.toString(), nameEdit.text.toString(), numberEdit.text.toString(), emailEdit.text.toString())
                (activity as MainActivity).AddContact(contact)

                idEdit.text.clear()
                nameEdit.text.clear()
                numberEdit.text.clear()
                emailEdit.text.clear()
            }
            else Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

}