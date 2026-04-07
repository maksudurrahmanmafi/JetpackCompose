package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OutlineTxt() {
    var text by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent), contentAlignment = Alignment.Center){
        OutlinedTextField(
            value = text,
            onValueChange = { valuechange ->
                text =valuechange
            },
            label = {
                Text("Enter your email")



            },
            placeholder = {
                Text("mafi@gmail.com")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = Color.Black,
                unfocusedBorderColor = Color.Red,
                focusedPlaceholderColor = Color.Red,
                focusedBorderColor = Color.Green
            )

        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Show(){
    OutlineTxt()
}