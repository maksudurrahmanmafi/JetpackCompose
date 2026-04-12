package com.example.jetpackcompose.BottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier

@Composable
fun InputChip(modifier: Modifier = Modifier) {


    var inputchip by remember {
        mutableStateOf(false)
    }

        if(!inputchip){

    InputChip(
    )
        }
}