package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.UserItemLayoutBinding
import com.example.recyclerview.user.UserItem

class UserItemAdapter(private val context: Context, private val userItemList: MutableList<UserItem>) : RecyclerView.Adapter<UserItemAdapter.UserItemViewHolder>() {

    inner class UserItemViewHolder(userItemLayoutBinding: UserItemLayoutBinding) : RecyclerView.ViewHolder(userItemLayoutBinding.root) {
        private val binding = userItemLayoutBinding
        fun bind(userItem: UserItem) {
            binding.tvName.text = userItem.name
            binding.tvSurname.text = userItem.surName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = UserItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userItemList.size
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val userItem = userItemList[position]
        holder.bind(userItem)
    }

}