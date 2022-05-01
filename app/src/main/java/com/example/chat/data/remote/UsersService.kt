package com.example.chat.data.remote

import com.example.chat.domain.model.Message
import com.example.chat.domain.model.User

interface UsersService {

    suspend fun getAllUsers(): List<User>

    suspend fun setUser(username: String)

    companion object {
        const val BASE_URL = "https://sometime-chat-server.herokuapp.com"
//        const val BASE_URL = "https://my-test-app-heroku21.herokuapp.com"
    }

    sealed class Endpoints(val url: String) {
        object GetAllUsers: Endpoints("$BASE_URL/users")
        object SetUser: Endpoints("$BASE_URL/insert_user?username=")
    }
}