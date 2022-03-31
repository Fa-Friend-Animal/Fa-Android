package com.example.fa_android.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val pink = Color(0xFFFFE1E1)
val lightPink = Color(0xFFFFEAEA)

@Composable
fun Main(modifier: Modifier = Modifier, navController: NavController) {

    Surface(modifier.background(lightPink)) {

        Column(
        ) {
            AnimalText()

            AnimalChipLayout()
            Spacer(modifier = modifier.height(10.dp))

            ComposePaint()

        }

    }
}




@Composable
@Preview
fun AnimalText(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier
            .fillMaxWidth()

    ) {

        Text(
            text = "이 6마리의 동물중 대화하고\n 싶은 동물을 그려보세요",
            style = TextStyle(
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(pink)
                .padding(16.dp)

        )
    }

}

@Composable
fun AnimalChipLayout(
    modifier: Modifier = Modifier,
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 26.dp, start = 46.dp, end = 43.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(lightPink),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 7.dp, top = 14.dp, end = 7.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            AnimalButton(name = "강아지")
            AnimalButton(name = "원숭이")
            AnimalButton(name = "말")

        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 7.dp, top = 14.dp, end = 7.dp, bottom = 17.dp),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            AnimalButton(name = "고양이")
            AnimalButton(name = "늑대")
            AnimalButton(name = "호랑이")


        }
    }


}

@Composable
fun AnimalButton(
    name: String
) {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(pink),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = pink
        )

    ) {
        Text(
            text = name,
            style = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )

        )
    }
}

