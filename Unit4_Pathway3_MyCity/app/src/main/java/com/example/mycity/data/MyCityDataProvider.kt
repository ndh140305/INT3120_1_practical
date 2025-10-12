package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Recomendation

object MyCityDataProvider {
    val categories = listOf(
        Category(
            id = 1,
            titleResourceId = R.string.category_food,
            imageResourceId = R.drawable.ic_category_food,
            recommendations = listOf(
                Recomendation(
                    id = 1,
                    titleResourceId = R.string.recommendation_cafe,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_cafe_square,
                    recomendImageBanner = R.drawable.ic_cafe_banner,
                    recomendDetails = R.string.recommendation_cafe_details
                ),
                Recomendation(
                    id = 2,
                    titleResourceId = R.string.recommendation_restaurant,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_restaurant_square,
                    recomendImageBanner = R.drawable.ic_restaurant_banner,
                    recomendDetails = R.string.recommendation_restaurant_details
                )
            )
        ),
        Category(
            id = 2,
            titleResourceId = R.string.category_entertainment,
            imageResourceId = R.drawable.ic_category_entertainment,
            recommendations = listOf(
                Recomendation(
                    id = 3,
                    titleResourceId = R.string.recommendation_park,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_park_square,
                    recomendImageBanner = R.drawable.ic_park_banner,
                    recomendDetails = R.string.recommendation_park_details
                ),
                Recomendation(
                    id = 4,
                    titleResourceId = R.string.recommendation_museum,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_museum_square,
                    recomendImageBanner = R.drawable.ic_museum_banner,
                    recomendDetails = R.string.recommendation_museum_details
                )
            )
        ),
        Category(
            id = 3,
            titleResourceId = R.string.category_culture,
            imageResourceId = R.drawable.ic_category_culture,
            recommendations = listOf(
                Recomendation(
                    id = 5,
                    titleResourceId = R.string.recommendation_theater,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_theater_square,
                    recomendImageBanner = R.drawable.ic_theater_banner,
                    recomendDetails = R.string.recommendation_theater_details
                ),
                Recomendation(
                    id = 6,
                    titleResourceId = R.string.recommendation_library,
                    subtitleResourceId = 0,
                    imageResourceId = R.drawable.ic_library_square,
                    recomendImageBanner = R.drawable.ic_library_banner,
                    recomendDetails = R.string.recommendation_library_details
                )
            )
        )
    )

    val defaultCategory = categories[0]
    val defaultRecommendation = categories[0].recommendations[0]
}