package com.dicoding.rumahkost.desy_githubuser_submission_i

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_menu_utama.*

class MenuUtama : AppCompatActivity() {
    private var userlist: ArrayList<UserData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)

        userlist.addAll(ObjectData.listData)
        showRecyclerView()


    }

    private fun showRecyclerView() {
        recyclerview_user.layoutManager = LinearLayoutManager(this)
        val RvaAdapter = UserAdapter(userlist)
        recyclerview_user.adapter = RvaAdapter

        RvaAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: UserData) {
                showSelectedData(data)
            }
        })
    }

    private fun showSelectedData(userdata: UserData) {
        val usersdata = UserData(
            userdata.username,
            userdata.name,
            userdata.avatar,
            userdata.company,
            userdata.location,
            userdata.repository,
            userdata.follower,
            userdata.following
        )
        val pindah = Intent(this@MenuUtama, DetailUser::class.java)
        pindah.putExtra(DetailUser.EXTRA_DATA,usersdata)
        startActivity(pindah)
    }
}
