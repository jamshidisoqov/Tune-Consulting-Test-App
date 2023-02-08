package uz.gita.tune_consulting.utils

import uz.gita.tune_consulting.R

// Created by Jamshid Isoqov on 2/8/2023

val tabList = listOf("All", "Favourites", "UzCard", "Humo", "International cards", "Atto")


private val images = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
)


fun getBackground(index: Int): Int = images[index % images.lastIndex]
