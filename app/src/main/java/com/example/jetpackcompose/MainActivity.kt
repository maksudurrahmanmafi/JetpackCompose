package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackcompose.lacture_1.greating
import com.example.jetpackcompose.lacture_1.image
import com.example.jetpackcompose.lacture_2.ScrollText
import com.example.jetpackcompose.lacture_2.SelectAbleTxt
import com.example.jetpackcompose.lacture_2.TextAndTypography
import com.example.jetpackcompose.lacture_2.fieldButton
import com.example.jetpackcompose.ui.theme.JetPackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackcomposeTheme {
//                ScrollText()
//
//                TextAndTypography()

//                SelectAbleTxt()

                fieldButton()


//                greating()
//                image()
            }
        }
    }
}

