package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a30days.model.DataSource.exercises
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.a30days.model.Exercises
import com.example.a30days.ui.theme._30daysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30daysTheme {
                Scaffold(topBar = {TopAppBar(modifier = Modifier)}) { innerPadding ->
                    LazyColumn(contentPadding = innerPadding) {
                        items(exercises) {
                            ExerciseCard(
                                exercise = it
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercises) {
    Card(
        modifier = Modifier.padding(
            horizontal = dimensionResource(R.dimen.padding_medium),
            vertical = dimensionResource(R.dimen.padding_small)
        )
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))) {
            Text(
                text = stringResource(exercise.day),
                style = MaterialTheme.typography.displaySmall)

            Text(text = stringResource(exercise.name),
                    style = MaterialTheme.typography.displaySmall)

            Image(
                painter = painterResource(exercise.img),
                contentDescription = stringResource(exercise.name),
                modifier = Modifier.size(dimensionResource(R.dimen.image_size))
                    .align(Alignment.CenterHorizontally)
            )

            Text(text = stringResource(exercise.description))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}