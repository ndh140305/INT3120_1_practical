package com.example.mycity.model

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

data class Recomendation(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val recomendImageBanner: Int,
    @StringRes val recomendDetails: Int
)
