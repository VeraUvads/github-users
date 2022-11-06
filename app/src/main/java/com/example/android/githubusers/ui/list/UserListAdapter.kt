package com.example.android.githubusers.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.githubusers.R
import com.example.android.githubusers.data.model.User

class UserListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var userList: MutableList<User> = mutableListOf()
    var onItemClickListener: (content: User) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        )
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserItemViewHolder).bind(userList[position])
    }

    fun addContent(users: List<User>) {
        this.userList.addAll(users)
        notifyDataSetChanged() // todo 
    }

    inner class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        val name = itemView.findViewById<TextView>(R.id.name)

        fun bind(content: User) {
            Glide.with(itemView.context).load(content.avatar_url).into(avatar)
            name.text = content.login
            itemView.setOnClickListener {
                onItemClickListener.invoke(content)
            }
        }
    }
}
