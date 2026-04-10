package com.example.jetpackcompose.BottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//
//@Preview(showSystemUi = true)
//@Preview(showSystemUi = true)
@Composable
fun LogInUI(modifier: Modifier = Modifier.fillMaxSize(),onNavigate :()->Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(top = 120.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Log In",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            style = TextStyle(
                shadow = Shadow(color = Color.Black, blurRadius = 10f)
            )
        )

        var emails by remember { mutableStateOf("") }
        var isfocuesd by remember { mutableStateOf(false) }

        OutlinedTextField(

            value = emails,
            onValueChange = { email -> emails = email },


            modifier = Modifier
                .onFocusChanged { focusState ->
                    isfocuesd = focusState.isFocused
                }
                .padding(top = 70.dp),
            shape = RoundedCornerShape(16.dp),

            leadingIcon = if (!isfocuesd) {
                {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                }
            } else null,

            label = { Text("Enter your email") },
            placeholder = { Text("like@gmail.com") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.Magenta,
                focusedPlaceholderColor = Color.Blue,
                focusedTextColor = Color.Red,
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.DarkGray
            )
        )
//        Spacer(Modifier.padding(20.dp))
        var password by remember { mutableStateOf("") }
        var isfocused by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },

            // ১. কন্ডিশনাল লিডিং আইকন
            leadingIcon = if (!isfocused) {
                {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
                }
            } else null,

            // ২. ফোকাস ট্র্যাকিং মডিফায়ার
            modifier = Modifier
                .padding()
                .onFocusChanged { focusState ->
                    isfocused = focusState.isFocused
                },

            // ৩. পাসওয়ার্ড মাস্কিং (যাতে লেখা দেখা না যায়)
            visualTransformation = PasswordVisualTransformation(),

            label = { Text("Enter your password") },
            shape = RoundedCornerShape(16.dp), // আগের মতো রেডিয়াস যোগ করা হলো

            colors = OutlinedTextFieldDefaults.colors(
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.Magenta,
                focusedPlaceholderColor = Color.Blue,
                focusedTextColor = Color.Red,
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.DarkGray
            )
        )
        val keybordcontroller = LocalSoftwareKeyboardController.current

        Button(
            onClick = {
                // মাফি স্যার, এখানে আপনার লগইন লজিক থাকবে
                keybordcontroller?.hide()
                onNavigate()
            },
            modifier = Modifier
                .width(150.dp)
                .height(55.dp) // ৪0dp খুব ছোট হতে পারে, ৫0-৫৫dp স্ট্যান্ডার্ড
                .padding(top = 10.dp), // প্যাডিং এর মান দিতে হয়
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red, // ব্যাকগ্রাউন্ড কালার
                contentColor = Color.White   // টেক্সট কালার
            ),
            shape = RoundedCornerShape(12.dp) // বাটনটি একটু গোল করার জন্য
        ) {
            Text("Log in")
        }

    }
}

// এটি অবশ্যই ইমপোর্ট করতে হবে

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login" // প্রথমে লগইন পেজ দেখাবে
    ) {
        // ১. লগইন স্ক্রিন সেটআপ
        composable("login") {
            LogInUI(onNavigate = {
                // বাটনে ক্লিক করলে Basic_Design এ নিয়ে যাবে
                navController.navigate("bottom_sheet")
            })
        }

        // ২. আপনার Basic_Design স্ক্রিন
        composable("bottom_sheet") {
            // মাফি স্যার, এখানে আপনার সেই 'Basic_Design' ফাংশনটি কল করুন
            BottomSheet()
        }
    }
}