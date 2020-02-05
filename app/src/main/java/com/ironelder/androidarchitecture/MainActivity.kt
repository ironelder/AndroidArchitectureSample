package com.ironelder.androidarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_searchList.apply {
            adapter = SearchListAdapter()
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = linearLayoutManager
        }
        NetworkService.searchAPI.search("web", "test").enqueue(object : Callback<DataModel>{
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                (rv_searchList.adapter as? SearchListAdapter)?.setDocumentData(response.body()?.documents)
            }

        })
    }
}
