package com.example.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chat.presintation.chat.ChatScreen
import com.example.chat.presintation.username.UsernameScreen
import com.example.chat.presintation.users.UserScreen
import com.example.chat.ui.theme.SimpleChatAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleChatAppTheme {
                // A surface container using the 'background' color from the theme

//                UserScreen()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "username_screen"
                    ) {
                        composable(route = "username_screen") {
                            UsernameScreen(onNavigate = navController::navigate)
                        }
                        composable(
                            route = "chat_screen/{username}",
                            arguments = listOf(
                                navArgument(name = "username") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            ChatScreen(username = username)
                        }

                        composable(
                            route = "users_screen/{username}",
                            arguments = listOf(
                                navArgument(name = "username") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) {
                            val username = it.arguments?.getString("username")
                            UserScreen()
                        }
                    }
                }
            }
        }
    }
}


