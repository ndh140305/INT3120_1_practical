package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import javax.xml.transform.Source

class Topic(
    @StringRes val stringSourceId: Int,
    val numberSourceId: Int,
    @DrawableRes val imageSourceId: Int
)