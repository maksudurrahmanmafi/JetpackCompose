package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable


fun TextAndTypography(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Text("Hello android ",
            color = Color.Red,
            fontFamily = FontFamily.SansSerif,
            fontSize = 35.sp,
            style = TextStyle(
                shadow = Shadow(color = Color.Black, blurRadius = 20f)
            )



        )

    }


}

@Composable
fun ScrollText(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("Hey Everyone This is our project how it's look",
            modifier = Modifier.basicMarquee(),
            fontSize = 54.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,

        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun View(){
    ScrollText()
    TextAndTypography()
}