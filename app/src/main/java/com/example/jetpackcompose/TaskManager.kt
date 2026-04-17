package com.example.jetpackcompose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TaskManager(modifier: Modifier = Modifier.background(Color.White)) {
    val context = LocalContext.current
    var state by remember {
        mutableStateOf("")
    }
    var btnTxt by remember {
        mutableStateOf("Add Task")
    }
    val taskList = remember { mutableStateListOf<String>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            "Task Manager",
            style = TextStyle(
                textAlign = TextAlign.Center,
                shadow = Shadow(Color.Cyan, blurRadius = 5f)


                ),
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,

        )
        OutlinedTextField(

            value = state,
            onValueChange = {
                state = it
            }
            ,
            label = {
                Text("Enter your Task")
            },
            placeholder ={
                Text("like : play football")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedLabelColor = Color.Red,
                focusedLabelColor = Color.Green,
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.Green,
                focusedPlaceholderColor = Color.Cyan
            )

        )

        val scope = rememberCoroutineScope()
        Button( onClick = {

            if(state.isNotEmpty()){
                taskList.add(state)
                state = ""
                btnTxt="Added"
                Toast.makeText(context,"Task added successfully",Toast.LENGTH_SHORT).show()


                scope.launch {
                    delay(2000)
                    btnTxt = "Add task "
                }
            }

            else {
                Toast.makeText(context,"Please enter a task",Toast.LENGTH_SHORT).show()
            }

        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.LightGray
            ),
            modifier = Modifier.padding(top = 10.dp)
        ) {

            Text(
                text = btnTxt
            )
        }

        LazyColumn (modifier = Modifier.fillMaxWidth().padding(top = 20.dp)){

            items(taskList){task->
                Card (modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    elevation = CardDefaults.cardElevation(5.dp)){
                    Text(
                        text =  task,
                        Modifier.padding(16.dp),
                        fontSize = 18.sp
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Exprev() {
    TaskManager()
}