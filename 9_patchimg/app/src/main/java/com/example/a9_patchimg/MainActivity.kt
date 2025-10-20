package com.example.a9_patchimg

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.a9_patchimg.ui.theme._9_patchImgTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(R.drawable.img), contentDescription = "")

                AndroidView(
                    factory = { context ->
                        ImageView(context).apply {
                            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.img2))
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

