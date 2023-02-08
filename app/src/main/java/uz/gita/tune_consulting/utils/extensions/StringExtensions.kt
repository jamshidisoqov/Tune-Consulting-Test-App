package uz.gita.tune_consulting.utils.extensions
// Created by Jamshid Isoqov on 2/7/2023


fun String.combine(string: String) = "$this $string"

//1234 5678 1234 1234
//1234 **** **** 1234
fun String.getCardType(): String {
    val arr = this.split(" ")
    val builder = StringBuilder(arr[0])
    for (i in 1..arr.size - 2) {
        builder.append(" ****")
    }
    builder.append(" ${arr[3]}")
    return builder.toString()
}