package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCard()
        }
    }
    @Preview
    @Composable
    fun BusinessCard() {
        Column(modifier = Modifier.background(Color.White).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(top = 200.dp, start = 10.dp, end = 10.dp, bottom = 100.dp)) {
                Image(
                    painter = painterResource(R.drawable.android_logo),
                    modifier = Modifier.fillMaxWidth(0.3f),
                    alignment = Alignment.Center,
                    contentDescription = "android_logo"
                )
                Text(text = "Nguyen Dinh Hieu", fontSize = 30.sp)
                Text(text = "Learner", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 10.dp)) {
                Contact(Icons.Filled.Call, "call", "0111 222 333")
                Contact(Icons.Filled.Share, "share", "@ndh")
                Contact(Icons.Filled.Email, "email", "23021548@vnu.edu.vn")
            }
        }
    }
    @Composable
    fun Contact(v: ImageVector, content: String, contact: String) {
        Row {
            Icon(imageVector = v, contentDescription = content, modifier = Modifier.size(20.dp))
            Text(text = contact, fontSize = 20.sp)
        }
    }
}


