package com.example.android.githubusers

import android.os.Bundle
import com.example.android.githubusers.extensions.appComponent
import com.example.android.githubusers.ui.base.BaseActivity
import com.example.android.githubusers.ui.list.UserListFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {
//    @Inject  // todo test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        appComponent.injectMainActivity(this) // todo пока не нужен

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, UserListFragment()).commit()
        }
    }
}
