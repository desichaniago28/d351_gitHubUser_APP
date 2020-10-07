package com.dicoding.rumahkost.desy_githubuser_submission_i

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.list_user_data.view.*


class UserAdapter(private val listusers: ArrayList<UserData>) :
    RecyclerView.Adapter<UserAdapter.usersadapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): UserAdapter.usersadapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_user_data, parent, false)
        return usersadapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: usersadapterViewHolder, position: Int) {
        val userdata =listusers[position]
        Glide.with(holder.itemView.context)
            .load(userdata.avatar)
            .apply(RequestOptions().override(150,150))
            .into(holder.imageAvatar)
        holder.name.text=userdata.name
        holder.username.text=userdata.username
        holder.company.text=userdata.company
        holder.lokasi.text=userdata.location
        holder.repository.text=userdata.repository.toString()
        holder.follower.text=userdata.follower.toString().trim()
        holder.following.text=userdata.following.toString().trim()
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listusers[holder.adapterPosition]) }

    }
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: UserData)
    }
    override fun getItemCount(): Int {
        return listusers.size
    }

    inner class usersadapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageAvatar: CircleImageView = itemView.img_item_photo
        var name: TextView = itemView.item_name
        var username: TextView = itemView.item_username
        var company: TextView = itemView.item_company
        var lokasi: TextView = itemView.item_lokasi
        var repository:TextView= itemView.item_repository
        var follower: TextView = itemView.item_follower
        var following: TextView = itemView.item_following


    }

}
