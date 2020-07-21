package com.devfptpoly.admin.localcachewithretrofitroomdb

import android.os.Bundle
import com.bumptech.glide.Glide
import com.devfptpoly.admin.localcachewithretrofitroomdb.model.Profile
import com.devfptpoly.admin.localcachewithretrofitroomdb.network.GithubApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var githubApi: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        githubApi.getProfile().enqueue(object : Callback<Profile> {
//            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
//                tv_response.text = "${response.body()?.avatar_url}"
//                showProgressBar(false)
//            }
//
//            override fun onFailure(call: Call<Profile>, t: Throwable) {
//                tv_response.text = "${t.message}"
//                showProgressBar(false)
//            }
//        })
        githubApi.rxGetProfile().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy (
                onSuccess = {
                    Glide.with(this).load(it.avatar_url).into(imgAvatar)
                    tv_response.text = it.login
                    showProgressBar(false)
                },
                onError =  {
                    tv_response.text = "${it.message}"
                    showProgressBar(false)
                }
            )

    }

}