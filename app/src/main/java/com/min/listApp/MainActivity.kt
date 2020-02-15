package com.min.listApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        Log.e("MIN", "requestSearchImage => ")
        SearchRetrofit.getService().requestSearchImage(keyword = "iPhone", page = 1).enqueue(object:
            Callback<Image> {
            override fun onFailure(call: Call<Image>, t: Throwable) {
                Log.e("MIN", "onFailure:${t.message}")
            }

            override fun onResponse(call: Call<Image>, response: Response<Image>) {
                Log.e("MIN", "onResponse => ${response.isSuccessful}")
                if (response.isSuccessful) {
                    val image = response.body()
                    Log.e("MIN", "===> ${image?.meta?.total_count}")
                    list_main.adapter = MainListAdapter(image?.documents!!)
                } else {
                    Log.e("MIN", response.message())
                }
            }

        })
    }
}

