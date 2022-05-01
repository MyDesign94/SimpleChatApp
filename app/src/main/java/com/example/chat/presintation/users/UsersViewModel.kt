package com.example.chat.presintation.users

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chat.data.remote.UsersService
import com.example.chat.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersService: UsersService
): ViewModel() {

    private val _userList = mutableStateOf<List<User>>(emptyList())
    val userList: State<List<User>> = _userList

    fun getAllUsers(username: String) {
        viewModelScope.launch {
            val result = usersService.getAllUsers(username)
            _userList.value = result
            Log.e("!!!", result.toString())
        }
    }

}