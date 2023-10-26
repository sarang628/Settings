package com.sryang.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.torangscreensettings.compose.SettingsScreen
import com.sryang.settings.ui.theme.SettingsTheme
import com.sryang.torang_repository.repository.LoginRepository
import com.sryang.torang_repository.repository.LoginRepositoryTest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginRepository: LoginRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        SettingsScreen(onLogout = { }, onBack = {})
                        //LoginRepositoryTest(loginRepository = loginRepository)
                    }
                }
            }
        }
    }
}