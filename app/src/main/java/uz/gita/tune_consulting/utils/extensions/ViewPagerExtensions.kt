package uz.gita.tune_consulting.utils.extensions

import androidx.viewpager2.widget.ViewPager2

// Created by Jamshid Isoqov on 12/18/2022


fun ViewPager2.onPageCallback(onPageScrolled: (Int) -> Unit) {
    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            onPageScrolled.invoke(position)
        }
    })
}