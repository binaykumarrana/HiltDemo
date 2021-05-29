package com.binay.hiltdemo.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.binay.hiltdemo.data.model.User
import com.binay.hiltdemo.databinding.ActivityMainBinding
import com.binay.hiltdemo.extention.hide
import com.binay.hiltdemo.extention.show
import com.binay.hiltdemo.ui.adapter.UserAdapter
import com.binay.hiltdemo.ui.viewmodel.UserViewModel
import com.binay.hiltdemo.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        userAdapter = UserAdapter(arrayListOf())
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    (binding.rvUser.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
    }

    private fun setupObserver() {
        userViewModel.users.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { users -> renderList(users) }
                }
                Status.LOADING -> {
                    //show loading
                }
                Status.ERROR -> {
                    //Handle Error
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        userAdapter.addData(users)
        userAdapter.notifyDataSetChanged()
    }
}