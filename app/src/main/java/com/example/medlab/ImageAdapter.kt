package com.example.medlab

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import org.w3c.dom.Text

class ImageAdapter(private val imageList: ArrayList<Int>,private val viewPager2: ViewPager2, private val textList:ArrayList<String>,private val textDescrList:ArrayList<String>):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.imageView)
        val textView:TextView = itemView.findViewById(R.id.textView2)
        val textDescr:TextView = itemView.findViewById(R.id.textDescr)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater .from(parent.context ).inflate(R.layout.image_container,parent,false )
        return ImageViewHolder(view)


    }

    override fun getItemCount(): Int {
      return imageList.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int,) {

        holder.imageView.setImageResource(imageList[position])
        holder.textView.text = textList[position]
        holder.textDescr.text = textDescrList[position]
        Log.d("position",position.toString())

    }
    

}