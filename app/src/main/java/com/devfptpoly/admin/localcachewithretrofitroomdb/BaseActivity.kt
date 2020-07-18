package com.devfptpoly.admin.localcachewithretrofitroomdb

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {
        val params : ViewGroup.LayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val paramsProgress : ViewGroup.LayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val frameLayout = FrameLayout(applicationContext)
        frameLayout.layoutParams = params
        mProgressBar = ProgressBar(applicationContext)
        mProgressBar.layoutParams = paramsProgress
        frameLayout.addView(mProgressBar)

        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(layoutResID)
    }

    fun showProgressBar(isLoading: Boolean) {
        val isProgressBarVisible: Int = if (isLoading) View.VISIBLE else View.INVISIBLE
        mProgressBar.visibility = isProgressBarVisible
    }
}