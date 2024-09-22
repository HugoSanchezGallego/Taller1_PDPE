package com.taller1_pdpe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taller1_pdpe.ui.theme.Taller1_PDPETheme
import java.util.*

class PantallaInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1_PDPETheme {
                PantallaInicioContent()
            }
        }
    }
}

@Composable
fun PantallaInicioContent() {
    val context = LocalContext.current
    val backgroundColor = getSavedColor(context)
    val saludo = obtenerSaludo()
    val imageResId = obtenerImageResId(saludo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = saludo)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Ir a Actividad Principal")
        }
    }
}

fun obtenerSaludo(): String {
    val hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hora) {
        in 0..11 -> "Buenos días"
        in 12..17 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

fun obtenerImageResId(saludo: String): Int {
    return when (saludo) {
        "Buenos días" -> R.drawable.buenos_dias
        "Buenas tardes" -> R.drawable.buenas_tardes
        else -> R.drawable.buenas_noches
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    Taller1_PDPETheme {
        PantallaInicioContent()
    }
}


