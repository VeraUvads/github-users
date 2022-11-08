package com.example.android.githubusers.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.android.githubusers.extensions.appComponent

abstract class BaseFragment @JvmOverloads constructor(
    @LayoutRes layoutRes: Int = 0
) : Fragment(layoutRes){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.appComponent?.inject(this)
    }
}