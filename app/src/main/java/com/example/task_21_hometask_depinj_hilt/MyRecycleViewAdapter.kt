package com.example.task_21_hometask_depinj_hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyRecycleViewAdapter(private val items:List<SuperHero>, callback:(result:String)->Unit): RecyclerView.Adapter<MyRecycleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleViewHolder {
        val listItemViewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return MyRecycleViewHolder(listItemViewHolder)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyRecycleViewHolder, position: Int) {
        holder.title.text = items[position].name
        holder.gender.text = items[position].appearance.gender
        Glide.with(holder.itemView)
            .load(items[position].images.xs)
            .into(holder.imageView)

//        Glide.with(holder.imageView.context)
//            .asBitmap()
//            .load("your url")
//            .into(object : BitmapImageViewTarget(holder.imageView) {
//                override fun setResource(resource: Bitmap?) {
//                    holder.imageView.setImageBitmap(resource)
//                    super.setResource(resource)
//                }
//            })

//        GlideApp.with(holder.itemView)
//            .load(items[position].images.sm)
//            .placeholder(Android.drawable.boy_32)
//            .into(holder.imageView);

    }
}

class MyRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title:TextView = itemView.findViewById(R.id.tvName)
    val imageView:ImageView = itemView.findViewById(R.id.image)
    val gender:TextView = itemView.findViewById(R.id.tvGender)
}

//@GlideModule
//class GlideApp : AppGlideModule()

