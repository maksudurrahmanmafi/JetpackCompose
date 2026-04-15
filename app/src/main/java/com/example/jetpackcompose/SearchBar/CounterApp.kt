package com.example.jetpackcompose.SearchBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.lacture_2.SliderExample


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterApp() {

    var count by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Counter App") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { count++ }
            ) {
                Text("+")
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Count: $count",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun sliderPreview() {
    CounterApp()
}
