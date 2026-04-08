package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun SelectAbleTxt(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        SelectionContainer {
            Column {
                Text("This is mafi and a montu developer",
                    modifier = Modifier.basicMarquee(),
                    fontSize = 35.sp,
                    )
                Text("This is mafi ")
                Text("This is mafi ")
                Text("This is mafi ")
                Text("This is mafi ")
                DisableSelection {

                Text("This is mafi ")
                Text("This is mafi ")
                }
            }
        }
    }
}