package com.example.fragmentcontact

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val dataset: ArrayList<Items>, private val itemClickListener: (Items) -> Unit) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val thumb: ImageView = view.findViewById(R.id.imageView)
        val name: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ItemHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        holder.thumb.setImageResource(dataset[position].thumb)
        holder.name.text = dataset[position].name

        holder.view.setOnClickListener {
            val item = dataset[position]
            itemClickListener.invoke(item)
        }

        val pop = PopupMenu(holder.itemView.context, holder.itemView)
        pop.menuInflater.inflate(R.menu.menu, pop.menu)

        holder.view.setOnLongClickListener {
            pop.show()
            true
        }

        pop.setOnMenuItemClickListener { choie ->
            when (choie.itemId) {
                R.id.call -> {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${dataset[position].number}"))
                    holder.itemView.context.startActivity(intent)
                    true
                }
                R.id.sms -> {
                    val intent = Intent(Intent.ACTION_SEND, Uri.parse("smsto:${dataset[position].number}"))
                    holder.itemView.context.startActivity(intent)
                    true
                }
                R.id.email -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("jan@example.com"))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                    intent.putExtra(Intent.EXTRA_TEXT, "Email message text")
                    holder.itemView.context.startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
}