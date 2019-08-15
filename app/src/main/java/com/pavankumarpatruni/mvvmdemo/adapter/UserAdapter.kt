package com.pavankumarpatruni.mvvmdemo.adapter

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.pavankumarpatruni.mvvmdemo.R
import com.pavankumarpatruni.mvvmdemo.model.User
import kotlinx.android.synthetic.main.layout_item_user.view.*
import org.jetbrains.annotations.Nullable

class UserAdapter(private var context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: MutableList<User> = ArrayList()

    fun addItems(userList: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffUtils(this.userList, userList))

        this.userList.clear();
        this.userList.addAll(userList)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_item_user,
                view,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, index: Int) {
        val user = userList[index]

        Glide.with(context).load(user.avatar).into(viewHolder.imageView)
        viewHolder.textView.text = user.name
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.imageView
        val textView: TextView = itemView.textView
    }

    class UserDiffUtils(private val oldUsers: List<User>, private val newUsers: List<User>) :
        DiffUtil.Callback() {

        override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            return oldUsers[oldPosition].id == newUsers[newPosition].id
        }

        override fun getOldListSize(): Int {
            return oldUsers.size
        }

        override fun getNewListSize(): Int {
            return newUsers.size
        }

        override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            return oldUsers[oldPosition] == newUsers[newPosition]
        }

        @Nullable
        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }

    }

}
