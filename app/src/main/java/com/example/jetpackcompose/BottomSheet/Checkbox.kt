package com.example.jetpackcompose.BottomSheet

import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // এটি দিয়ে সব ম্যাটেরিয়াল ৩ কম্পোনেন্ট আসবে
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview(showSystemUi = true)
@Composable
fun SkillSelectionScreen() { // মাফি স্যার, নাম পরিবর্তন করে দিলাম যাতে লুপ না হয়

    val itemsList = listOf("Android", "Kotlin", "Compose", "Firebase")
    val selectedItems = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Select Your Skills:", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        itemsList.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)


            ) {
                // ম্যাটেরিয়াল ৩ এর আসল চেকবক্স
                Checkbox(
                    checked = selectedItems.contains(item),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedItems.add(item)
                        } else {
                            selectedItems.remove(item)
                        }
                    }
                )
                Text(text = item, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Text(
            text = "Total Selected: ${selectedItems.size}",
            modifier = Modifier.padding(top = 16.dp),
            color = Color.Red
        )
    }
}