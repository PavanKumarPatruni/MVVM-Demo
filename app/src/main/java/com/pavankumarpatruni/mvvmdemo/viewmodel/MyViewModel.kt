package com.pavankumarpatruni.mvvmdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pavankumarpatruni.mvvmdemo.model.User
import com.pavankumarpatruni.mvvmdemo.repo.UserRepository

class UserViewModel : ViewModel() {

    private var userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserList(): LiveData<List<User>> {
        userList = UserRepository.getInstance().getUserList()
        return userList
    }

    fun addUser() {
        val list = userList.value as MutableList<User>

        var size = list.size
        ++size

        list.add(
            User(
                "https://www.justvenue.com/assets/04ed1861.png",
                "New User $size",
                size
            )
        )

        userList.value = list
    }

}