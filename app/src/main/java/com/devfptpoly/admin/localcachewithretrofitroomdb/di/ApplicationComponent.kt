package com.devfptpoly.admin.localcachewithretrofitroomdb.di

import com.devfptpoly.admin.localcachewithretrofitroomdb.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class , ApiModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DaggerApplication) : Builder
        fun build(): ApplicationComponent
    }
}