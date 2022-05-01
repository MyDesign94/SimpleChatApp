package com.example.chat.data.remote

import android.util.Log
import com.example.chat.data.remote.dto.MessageDto
import com.example.chat.data.remote.dto.UserDto
import com.example.chat.domain.model.Message
import com.example.chat.domain.model.User
import io.ktor.client.*
import io.ktor.client.request.*

class UsersServiceImpl(
    private val client: HttpClient
): UsersService {
    override suspend fun getAllUsers(): List<User> {
        return try {
            client.get<List<UserDto>>(UsersService.Endpoints.GetAllUsers.url)
                .map { it.toUser() }
        } catch (e: Exception) {

            Log.e("getAllUsers()", "${e.localizedMessage}")
            emptyList<User>()
        }
    }

    override suspend fun setUser(username: String) {
        try {
            client.get<String>(UsersService.Endpoints.SetUser.url + username)
        } catch (e: Exception) {
            Log.e("setUser()", "${e.localizedMessage}")
        }
    }
}