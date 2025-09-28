package com.example.affirmations

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringSourceId: Int,
    @DrawableRes val imageSourceId: Int
)