import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sryang.torang_repository.session.SessionService


@Composable
fun SettingsScreen(onLogout: (Int) -> Unit) {
    val sessionService = SessionService(LocalContext.current)
    Column {
        Text(text = "Settings")
        sessionService.getToken()?.let {
            Text(text = "token:$it")
        }
        Button(onClick = {
            onLogout.invoke(0)
            sessionService.removeToken()
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
    val sessionService = SessionService(LocalContext.current)
    Column {
        Button(onClick = { sessionService.saveToken("abcd") }) {
            Text(text = "Login")
        }
    }
}