package com.example.fragmentcontact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    val danhba = ArrayList<Items>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        danhba.add(Items(R.drawable.j, "1", "Josefina Lehner", "16059719337", "josef@gmail.com"))
        danhba.add(Items(R.drawable.s, "2", "Stuart Vandervort II", "12794992386", "stuart@gmail.com"))
        danhba.add(Items(R.drawable.m, "3", "Maddison Russel", "13479466861", "russel@gmail.com"))
        danhba.add(Items(R.drawable.h, "4", "Halie Morar II", "16059714423", "morar2@gmail.com"))
        danhba.add(Items(R.drawable.k, "5", "Karelle Simonis", "12794992386", "simonis@gmail.com"))
        danhba.add(Items(R.drawable.h, "6", "Hannah Welch", "127458196482", "hannah@gmail.com"))
        danhba.add(Items(R.drawable.f, "7", "Fanny Frami", "137458196483", "fanny@gmail.com"))
        danhba.add(Items(R.drawable.e, "8", "Elfrieda Wisozk", "167458196925", "elfrieda@gmail.com"))

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         return  inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<RecyclerView>(R.id.list_view)

        listView.adapter = ItemAdapter(danhba) { item ->
            (activity as MainActivity).UpdateDetail(item.thumb, item.id, item.name, item.number, item.email)
        }

        listView.layoutManager = LinearLayoutManager(requireContext())

        view.findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            (activity as MainActivity).CallAddContact()
        }
    }

}
