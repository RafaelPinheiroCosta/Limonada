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
fun LimonadaTextoImagem(
                        recursoTextoId: Int,
                        recursoImagemId: Int,
                        onImagemClick:() ->Unit,
                        modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = recursoTextoId),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = recursoImagemId),
            contentDescription = null,

            modifier = Modifier
                .wrapContentSize()
                .clickable(onClick = onImagemClick)
                .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
            
        )
    }
}

@Preview
@Composable
fun LimonadaApp() {

    var passoAtual by remember { mutableStateOf(1) }
    var quantidadeDeEspremidas by remember { mutableStateOf(0) }

    when(passoAtual){
        1 ->{
            LimonadaTextoImagem(
                R.string.Limoeiro,
                R.drawable.lemon_tree,
                onImagemClick = {
                    passoAtual = 2
                    quantidadeDeEspremidas = (2..4).random()
                }
            )
        }
        2 ->{
            LimonadaTextoImagem(
                R.string.Limao,
                R.drawable.lemon_squeeze,
                onImagemClick = {
                    quantidadeDeEspremidas--
                    quantidadeDeEspremidas--
                    if(quantidadeDeEspremidas==0)
                        passoAtual = 3
                }
            )

        }
        3 ->{
            LimonadaTextoImagem(
                R.string.copo_de_limonada,
                R.drawable.lemon_drink,
                onImagemClick = { passoAtual = 4 }
            )
        }
        4 ->{
            LimonadaTextoImagem(
                R.string.copo_vazio,
                R.drawable.lemon_restart,
                onImagemClick = { passoAtual = 1 }
            )
        }
    }
}