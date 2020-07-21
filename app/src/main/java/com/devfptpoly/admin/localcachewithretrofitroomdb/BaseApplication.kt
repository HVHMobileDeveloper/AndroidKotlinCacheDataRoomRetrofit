package com.devfptpoly.admin.localcachewithretrofitroomdb

import android.app.Application
import com.devfptpoly.admin.localcachewithretrofitroomdb.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()
}