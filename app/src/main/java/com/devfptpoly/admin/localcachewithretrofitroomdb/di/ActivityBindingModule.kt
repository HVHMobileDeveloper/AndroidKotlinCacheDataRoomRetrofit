package com.devfptpoly.admin.localcachewithretrofitroomdb.di

import com.devfptpoly.admin.localcachewithretrofitroomdb.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}