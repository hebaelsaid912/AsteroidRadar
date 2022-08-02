package com.udacity.asteroidradar.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.model.Asteroid
import com.udacity.asteroidradar.R

class MainAsteroidAdapter(var listener: ListenerGoToDetails) :
    RecyclerView.Adapter<MainAsteroidAdapter.MainAsteroidViewHolder>() {
    private var mlist = ArrayList<Asteroid>()
    lateinit var context: Context

    class MainAsteroidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var name: TextView = itemView.description_tv_likes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAsteroidViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_asteroid_item_list, parent, false)
        return MainAsteroidViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainAsteroidViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    fun setList(context: Context, mlist: ArrayList<Asteroid>) {
        this.mlist = mlist
        this.context = context
    }

    fun removeAt(position: Int) {

    }

}


interface ListenerGoToDetails {
    fun onClickedOnLike(position: Int, product_id: Int, likeBtn: ImageView)
    fun onClickToIntent(position: Int, product_id: Int)
}