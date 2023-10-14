import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.torangscreensettings.R
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen(onLogout: (Int) -> Unit) {
    val coroutine = rememberCoroutineScope()
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
                Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = " Settings and privacy", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        LoginSetting()
    }
}

@Preview
@Composable
fun LoginSetting() {
    Column(
        Modifier
            .background(Color(0x33FFFFFF))
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Login", color = Color.Gray, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
        {
            Text(
                text = "Log out torang",
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
    })
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