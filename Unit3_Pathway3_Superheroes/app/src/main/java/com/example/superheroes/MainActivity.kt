package com.example.superheroes

import HeroTypography
import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme() {
                HeroApp()
            }
        }
    }

    @Composable
    @Preview
    fun HeroApp() {
        Scaffold(topBar = { TopAppBar(modifier = Modifier) }) {
            it ->
            LazyColumn(contentPadding = it) {
                items(heroes) {
                    HeroCard(
                        hero = it
                    )
                }
            }

        }
    }

    @Composable
    fun HeroCard(hero: Hero) {
        Card(modifier = Modifier.padding(
            horizontal = dimensionResource(R.dimen.padding_medium),
            vertical = dimensionResource(R.dimen.padding_small)
        )) {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(
                        text = stringResource(hero.nameRes),
                        style = MaterialTheme.typography.displaySmall

                    )
                    Text(
                        text = stringResource(hero.descriptionRes),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .clip(shape = MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop,
                )
            }
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