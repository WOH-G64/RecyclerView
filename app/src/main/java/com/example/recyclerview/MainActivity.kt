package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.UserItemAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.user.UserItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: UserItemAdapter
    private val userItemList = mutableListOf<UserItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateList()
        setUpAdapter()

    }

    fun populateList() {
        repeat(20) {
            userItemList.add(UserItem("Name: ${it + 1}", "Surname: ${it + 1}"))
        }
    }

    fun setUpAdapter() {
        adapter = UserItemAdapter(this, userItemList)
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvUser.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}