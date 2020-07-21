package com.devfptpoly.admin.localcachewithretrofitroomdb

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var activityContainer: FrameLayout

    override fun setContentView(layoutResID: Int) {
        val rootLayout: ConstraintLayout = layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        activityContainer = rootLayout.findViewById(R.id.activity_content) as FrameLayout
        progressBar = rootLayout.findViewById(R.id.progress_bar) as ProgressBar

        layoutInflater.inflate(layoutResID, activityContainer, true)
        super.setContentView(rootLayout)
    }

    fun showProgressBar(isLoading: Boolean) {
        val isProgressBarVisible: Int = if (isLoading) View.VISIBLE else View.GONE
        progressBar.visibility = isProgressBarVisible
    }
}