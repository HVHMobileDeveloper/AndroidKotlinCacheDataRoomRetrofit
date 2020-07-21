package com.devfptpoly.admin.localcachewithretrofitroomdb.network

import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubService () {

    companion object Factory{

        fun create(): GithubApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            return retrofit.create(GithubApi::class.java)
        }

    }
}