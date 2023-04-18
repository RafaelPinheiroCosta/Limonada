package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LimonadaApp()
                }
            }
        }
    }
}

@Composable
fun LimonadaTextoImagem(modifier: Modifier = Modifier) {

    var descricao = stringResource(id = R.string.Limao)

    var resultado by remember { mutableStateOf(1) }

    var imagem =  when(resultado){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = descricao,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imagem),
            contentDescription = descricao,

            modifier = Modifier
                .wrapContentSize()
                .clickable {
                    if(resultado>5)
                        resultado++
                    else
                        resultado=1
                }
                .border(2.dp, Color(105,205,216), RoundedCornerShape(10.dp))
                .padding(16.dp)
            
        )
    }
}

@Preview
@Composable
fun LimonadaApp() {
    LimonadaTextoImagem()
}