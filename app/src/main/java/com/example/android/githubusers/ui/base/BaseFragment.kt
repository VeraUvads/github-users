package com.example.android.githubusers.ui.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment @JvmOverloads constructor(
    @LayoutRes layoutRes: Int = 0
) : Fragment(layoutRes) {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
