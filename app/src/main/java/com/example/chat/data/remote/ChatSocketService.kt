package com.example.chat.data.remote

import com.example.chat.domain.model.Message
import com.example.chat.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://sometime-chat-server.herokuapp.com"
//        const val BASE_URL = "ws://my-test-app-heroku21.herokuapp.com"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket: Endpoints("$BASE_URL/chat-socket")
    }
}