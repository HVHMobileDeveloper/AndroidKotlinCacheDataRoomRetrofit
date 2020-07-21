package com.devfptpoly.admin.localcachewithretrofitroomdb.network

import com.devfptpoly.admin.localcachewithretrofitroomdb.model.Profile
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi{

    @GET("users/HVHMobileDeveloper")
    fun getProfile() : Call<Profile>


    @GET("users/HVHMobileDeveloper")
    fun rxGetProfile() : Single<Profile>
}
