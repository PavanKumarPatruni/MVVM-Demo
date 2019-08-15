package com.pavankumarpatruni.mvvmdemo.repo

import android.arch.lifecycle.MutableLiveData
import com.pavankumarpatruni.mvvmdemo.model.User

class UserRepository {

    private var userList = ArrayList<User>()

    companion object {
        private lateinit var userRepository: UserRepository

        fun getInstance(): UserRepository {
            userRepository = UserRepository()
            return userRepository
        }
    }

    private fun setUsers() {
        userList.add(User("https://www.w3schools.com/howto/img_avatar.png", "Pavan", 1))
        userList.add(User("https://www.w3schools.com/w3images/avatar2.png", "PavanKumar", 2))
        userList.add(User("https://www.w3schools.com/bootstrap/img_avatar4.png", "Pavan Kumar", 3))
        userList.add(User("https://www.w3schools.com/bootstrap/img_avatar6.png", "Pavan Pathro", 4))
        userList.add(User(
            "https://cdn.pixabay.com/photo/2016/08/20/05/38/avatar-1606916_960_720.png",
            "Pathro",
            5
        ))
        userList.add(User("https://playjoor.com/assets/avatar/elliot.jpg", "Kumar", 6))
        userList.add(User(
            "https://res.cloudinary.com/dyhdmrsdc/image/upload/v1496245622/matthew_nuezrz.png",
            "PavanPathro",
            7
        ))
        userList.add(User("https://athityakumar.github.io/assets/images/dp.png", "Patruni", 8))
        userList.add(User(
            "https://thumbs.dreamstime.com/b/profile-icon-male-hispanic-avatar-portrait-casual-person-silhouette-face-flat-design-vector-52547911.jpg",
            "Keka",
            9
        ))
    }

    fun getUserList(): MutableLiveData<List<User>> {
        setUsers()

        val data = MutableLiveData<List<User>>()
        data.value = userList

        return data
    }

}