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

class UserListAdapter(private val onItemClickListener: (content: User) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var userList: MutableList<User> = mutableListOf()

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
        val lengthBeforeUpdate = users.size
        this.userList.addAll(users)
        notifyItemRangeChanged(lengthBeforeUpdate, users.size)
    }

    inner class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val avatar: ImageView = itemView.findViewById(R.id.avatar)
        private val name: TextView = itemView.findViewById(R.id.name)

        fun bind(content: User) {
            Glide.with(itemView.context).load(content.avatar_url).into(avatar)
            name.text = content.login
            itemView.setOnClickListener {
                onItemClickListener.invoke(content)
            }
        }
    }
}
