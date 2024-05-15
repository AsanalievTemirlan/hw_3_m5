package com.geeks.hw3_5m

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.hw_03_m5.CharactersResponse
import com.example.hw_03_m5.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val INITIAL_INDEX = 1

class CharactersDataSource() :
    PageKeyedDataSource<Int, com.example.hw_03_m5.Character>() {

    val loadState = MutableLiveData<Int>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, com.example.hw_03_m5.Character>
    ) {
        RetrofitService.api.getCharacter(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResult(response.body()!!.results!!, null, INITIAL_INDEX + 1)
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.e("tag","onFailure${t.localizedMessage}")
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, com.example.hw_03_m5.Character>) {

        var currentIndex = params.key

        RetrofitService.api.getCharacter(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResult(response.body()!!.results,  currentIndex + 1)
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.e("tag","onFailure${t.localizedMessage}")
            }
        })
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, com.example.hw_03_m5.Character>
    ) {
        TODO("Not yet implemented")
    }
}