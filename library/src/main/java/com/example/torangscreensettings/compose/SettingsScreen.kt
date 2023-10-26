package com.example.torangscreensettings.compose

import android.app.AlertDialog
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.torangscreensettings.R
import com.example.torangscreensettings.viewmodels.SettingsViewModel
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(), //뷰모델 주입
    onLogout: () -> Unit,
    onBack: () -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()

    // 클릭 시 리플 애니메이션을 없애기 위한 변수
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        Modifier
            .background(colorResource(id = com.sarang.theme.R.color.colorSecondaryLight))
            .fillMaxSize()
    ) {
        //title bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                Modifier
                    .size(25.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onBack.invoke() }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = " Settings and privacy", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        LoginSetting(onLogout = onLogout, id = uiState.id)
    }
}

@Composable
fun LoginSetting(onLogout: () -> Unit, id: String) {
    val context = LocalContext.current
    Column(
        Modifier
            .background(Color(0x33FFFFFF))
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ) {
        // 클릭 시 리플 애니메이션을 없애기 위한 변수
        val interactionSource = remember { MutableInteractionSource() }
        Text(text = "Login", color = Color.Gray, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    AlertDialog
                        .Builder(context)
                        .setMessage("로그아웃 하시겠습니까?")
                        .setPositiveButton("예") { _, _ -> onLogout.invoke() }
                        .setNegativeButton("아니오") { _, _ -> }
                        .show()
                }
        )
        {
            Text(
                text = "Log out $id", //아이디가 하드코딩 되어있음.
                color = Color.Red,
                modifier = Modifier.align(CenterStart),
                fontSize = 16.sp
            )
        }

    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    val context = LocalContext.current
    SettingsScreen(onLogout = {
        Toast.makeText(context, "logout", Toast.LENGTH_SHORT).show()
    }, onBack = {})
}

@Preview
@Composable
fun PreviewTest() {
    //val sessionService = SessionService(LocalContext.current)
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                //sessionService.saveToken("abcd")
            }
        }) {
            Text(text = "Login")
        }
    }
}