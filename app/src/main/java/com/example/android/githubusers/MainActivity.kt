package com.example.android.githubusers

import android.os.Bundle
import com.example.android.githubusers.utils.network.base.BaseActivity
import com.example.android.githubusers.ui.list.UserListFragment

class MainActivity : com.example.android.githubusers.utils.network.base.BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, UserListFragment()).commit()
        }
    }
}
