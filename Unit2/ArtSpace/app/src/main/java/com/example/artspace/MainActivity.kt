package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                artSpace()
            }
        }
    }
}

data class Art(
    val id: Int,
    val title: String,
    val year: String
)

val artWorks = listOf<Art>(
    Art(R.drawable.artwork_1, "Art 1", "1994"),
    Art(R.drawable.artwork_2, "Art 2", "1939"),
    Art(R.drawable.artwork_3, "Art 3", "1998")
)
@Preview
@Composable
fun artSpace() {
    var currentArtId by remember { mutableStateOf(0) }
    var art = artWorks.get(currentArtId)
    Column (
        Modifier
        .background(Color.White)
        .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        ShowArt(
            art.id
        )
        DescribeArt(
            art.title,
            art.year
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        SwitchArt(
            onPrevious = {
                if (currentArtId > 0) {
                    currentArtId--
                } else {
                    currentArtId = artWorks.size - 1
                }
            },
            onNext = {
                if (currentArtId < artWorks.size - 1) {
                    currentArtId++
                } else {
                    currentArtId = 0
                }
            }
        )
    }
}

@Composable
fun ShowArt(artworkId: Int) {
    Image(
        painterResource(artworkId),
        contentDescription = "art",
        modifier = Modifier.padding(all = 20.dp)
            .fillMaxWidth()
            .heightIn(600.dp)
            .background(color = Color.White),
        contentScale = ContentScale.Fit)
}

@Composable
fun DescribeArt(title: String, year: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
    ) {
        Text(
            title,
            fontSize = 30.sp,
//            modifier = Modifier.border(2.dp,
//                Color.Black,
////                RectangleShape
//            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(year,
            fontSize = 30.sp)
    }
}

@Composable
fun SwitchArt(onPrevious:()->Unit, onNext:()->Unit) {
    Row {
        Button(
            onClick = onPrevious,
            modifier = Modifier.weight(1f)
        ) {
            Text("Previous")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onNext,
            modifier = Modifier.weight(1f)
        ) {
            Text("Next")
        }
    }
}



