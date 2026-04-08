package com.example.jetpackcompose.lacture_2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    // Column ব্যবহার করে কম্পোনেন্টগুলোকে ওপর-নিচে সাজানো হয়েছে
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // ১. ইমেইল ইনপুট
        EmailInputField()

        Spacer(modifier = Modifier.height(16.dp)) // দুটির মাঝে গ্যাপ

        // ২. পাসওয়ার্ড ইনপুট
        PasswordInputField()

    }
}

@Composable
fun EmailInputField() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter your email") },
        placeholder = { Text("mafi@gmail.com") },
        modifier = Modifier.fillMaxWidth(), // যাতে ডানে-বামে পুরো জায়গা নেয়
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Color.Black,
            unfocusedBorderColor = Color.Red,
            focusedBorderColor = Color.Green
        )
    )
}

@Composable
fun PasswordInputField() {
    var password by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter your password") },
        placeholder = { Text("3204rusfkjak") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Color.Red,
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Green,
            unfocusedLabelColor = Color.Black
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun Show() {
    MainScreen()
}