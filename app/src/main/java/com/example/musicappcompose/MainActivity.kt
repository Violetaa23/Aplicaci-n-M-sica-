import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicappcompose.R
import com.example.musicappcompose.ui.theme.MusicAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicAppComposeTheme {
                MusicPlayerScreen()
            }
        }
    }
}
@Preview
@Composable
fun MusicPlayerScreen() {
    // Variable para manejar el estado del botón play/pause
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del disco
        Image(
            painter = painterResource(id = R.drawable.discooooo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )

        // Nombre de la canción y del grupo
        Text(text = "Nombre de la canción!", style = MaterialTheme.typography.headlineLarge, color = Color.White)
        Text(text = "Nombre grupo/Artista", style = MaterialTheme.typography.bodyLarge, color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        // Barra de progreso de la canción
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "1:00", color = Color.White)
            Slider(
                value = 0.25f,
                onValueChange = {},
                modifier = Modifier.weight(1f)
            )
            Text(text = "3:00", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botones de control (anterior, play/pause, siguiente)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Acción canción anterior */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.discooooo),
                    contentDescription = "Anterior",
                    tint = Color.White
                )
            }

            IconButton(onClick = { isPlaying = !isPlaying }) {
                Icon(
                    painter = painterResource(
                        id = if (isPlaying) R.drawable.discooooo else R.drawable.discooooo
                    ),
                    contentDescription = "Play/Pause",
                    tint = Color.White
                )
            }

            IconButton(onClick = { /* Acción canción siguiente */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.discooooo),
                    contentDescription = "Siguiente",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Barra de volumen
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Volumen", color = Color.White)
            Slider(
                value = 0.7f,
                onValueChange = {},
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botones de compartir, ver letra, ver listado
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Acción ver listado */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.discooooo),
                    contentDescription = "Ver listado",
                    tint = Color.White
                )
            }

            IconButton(onClick = { /* Acción ver letra */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.discooooo),
                    contentDescription = "Ver letra",
                    tint = Color.White
                )
            }

            IconButton(onClick = { /* Acción compartir */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.discooooo),
                    contentDescription = "Compartir",
                    tint = Color.White
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MusicAppComposeTheme {
        MusicPlayerScreen()
    }
}
