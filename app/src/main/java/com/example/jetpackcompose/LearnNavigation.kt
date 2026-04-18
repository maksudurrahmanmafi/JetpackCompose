package com.example.jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// ১. মেইন নেভিগেশন কন্ট্রোলার (ম্যাপ)
@Composable
fun SimpleNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNext = { navController.navigate("detail") })
        }
        composable("detail") {
            DetailScreen(onBack = { navController.popBackStack() })
        }
    }
}

// ২. হোম স্ক্রিন
@Composable
fun HomeScreen(onNext: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("এটা হোম স্ক্রিন")
        Button(onClick = onNext) { Text("ডিটেইলসে যাও") }
    }
}

// ৩. ডিটেইল স্ক্রিন
@Composable
fun DetailScreen(onBack: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("এটা ডিটেইল স্ক্রিন")
        Button(onClick = onBack) { Text("ফিরে যাও") }
    }
}