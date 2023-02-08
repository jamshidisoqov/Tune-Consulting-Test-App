package uz.gita.tune_consulting.utils.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

// Created by Jamshid Isoqov on 2/8/2023


//format MM/YY
@SuppressLint("SimpleDateFormat")
fun Long.toDateFormat(): String {
    val date = Date(this)
    return SimpleDateFormat("MM/yy").format(date)
}