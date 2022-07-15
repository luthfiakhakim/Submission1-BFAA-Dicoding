package com.dicoding.submission1_githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.submission1_githubuserapp.DetailUser.Companion.EXTRA_USER

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvUsername.text = user.username
        holder.tvName.text = user.name
        holder.tvLocation.text = user.location

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailUser::class.java)
            intent.putExtra(EXTRA_USER, user)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_user_photo)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_location)
    }
}