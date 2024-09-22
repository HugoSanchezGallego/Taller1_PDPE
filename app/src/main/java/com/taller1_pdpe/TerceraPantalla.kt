package com.taller1_pdpe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taller1_pdpe.ui.theme.Taller1_PDPETheme

class TerceraPantalla : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1_PDPETheme {
                TerceraPantallaContent()
            }
        }
    }
}

@Composable
fun TerceraPantallaContent() {
    val context = LocalContext.current
    var backgroundColor by remember { mutableStateOf(getSavedColor(context)) }
    val defaultColor = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla de Configuración")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            backgroundColor = Color.Red
            saveColor(context, backgroundColor)
        }) {
            Text("Cambiar a Rojo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            backgroundColor = Color.Green
            saveColor(context, backgroundColor)
        }) {
            Text("Cambiar a Verde")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            backgroundColor = Color.Blue
            saveColor(context, backgroundColor)
        }) {
            Text("Cambiar a Azul")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            backgroundColor = defaultColor
            saveColor(context, backgroundColor)
        }) {
            Text("Restablecer a Predeterminado")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val intent = Intent(context, PantallaInicio::class.java)
            context.startActivity(intent)
        }) {
            Text("Volver a la Pantalla de Inicio")
        }
    }
}

fun saveColor(context: Context, color: Color) {
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    with(sharedPreferences.edit()) {
        putInt("background_color", color.toArgb())
        apply()
    }
}

fun getSavedColor(context: Context): Color {
    val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val colorInt = sharedPreferences.getInt("background_color", Color.White.toArgb())
    return Color(colorInt)
}

@Preview(showBackground = true)
@Composable
fun TerceraPantallaPreview() {
    Taller1_PDPETheme {
        TerceraPantallaContent()
    }
}