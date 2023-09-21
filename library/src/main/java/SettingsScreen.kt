import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen(onLogout: (Int) -> Unit) {
    val coroutine = rememberCoroutineScope()
    Column {
        Text(text = "Settings")
        //Text(text = "token:${sessionService.getToken()}")
        Button(onClick = {
            onLogout.invoke(0)
            coroutine.launch {

            }
        }) {
            Text(text = "로그아웃")
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