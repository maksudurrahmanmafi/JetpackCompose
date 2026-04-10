package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn // Explicitly imported
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//@Preview(showSystemUi = true)
@Composable
fun MyLazyColumn() {
    val itemlist = listOf("Mafi", "Jui", "1", "Meraj", "Hello","one","two","three","four","five","six","ase","hello") // String list

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Text(
                    text = "Learning Jetpack",
                    style = MaterialTheme.typography.headlineMedium
                )
            }


            items(itemlist) { name ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = name,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MyLazyRow(){
    val itemsList = arrayOf(1,3,4,3,3,24,45,15,34,51,33,15,1)

    LazyRow (modifier = Modifier.height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)){

        items( itemsList){ row->

            Card {
                Text(
                    text = row.toString(),
                    modifier = Modifier.padding(16.dp)
                )

            }

        }


    }
}