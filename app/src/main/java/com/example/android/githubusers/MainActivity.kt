package com.example.android.githubusers

import android.os.Bundle
import com.example.android.githubusers.ui.base.BaseActivity
import com.example.android.githubusers.ui.list.UserListFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, UserListFragment()).commit()
    }
}
