package com.devfptpoly.admin.localcachewithretrofitroomdb.di

import com.devfptpoly.admin.localcachewithretrofitroomdb.network.GithubService
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides
    fun provideApiModule() = GithubService.create()
}