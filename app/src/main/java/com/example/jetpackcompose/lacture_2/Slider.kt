package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderExample(modifier: Modifier = Modifier) {

    var slidervalue by remember {
        mutableStateOf(0)
    }

    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Value :${slidervalue} "
            ,
            Modifier.padding(bottom = 16.dp)
        )
        Slider(
            value = slidervalue.toFloat(),
            onValueChange = {
                slidervalue = it.toInt()
            }
            ,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTickColor = MaterialTheme.colorScheme.tertiary
            )
            ,
            steps = 12,
            valueRange = 0f..100f
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun sliderPreview() {
    SliderExample()
}