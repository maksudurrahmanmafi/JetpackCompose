package com.example.jetpackcompose.lacture_2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun fieldButton(){
    val mafi = LocalContext.current
    Box(modifier = Modifier.fillMaxSize().background(Color.Cyan), contentAlignment = Alignment.Center){
        Column(modifier = Modifier.fillMaxSize().padding(16.dp,),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            EmailInputField()
            PasswordInputField()

            Button(     onClick = {
                // ২. context ব্যবহার করে টোস্ট দেখানো
                Toast.makeText(mafi, "Button clicked", Toast.LENGTH_SHORT).show()
            },


            ) {


                Text("Click me ")

                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Click here"
                )
            }
            FloatingActionButton(onClick = {
                

            },
                contentColor = Color.Red,
                containerColor = Color.Green

            ) {
                Icon(
                    imageVector = Icons.Default.Place, // ডিফল্ট 'Plus' আইকন
                    contentDescription = "Add Icon"
                )

            }

            OutlinedButton(onClick = { /* Action */ }) {
                Text("Outlined Button")
            }

            ElevatedButton(onClick = { /* Action */ }) {
                Text("Elevated Button")
            }
            FilledTonalButton(onClick = { /* Action */ }) {
                Text("Tonal Button")
            }

            TextButton(onClick = { /* Action */ }) {
                Text("Text Button")
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Icon"

                )

            }




        }
    }


}
@Preview(showSystemUi = true)
@Composable
fun Buttonshow(){
    fieldButton()
}