package uz.gita.tune_consulting.utils.extensions
// Created by Jamshid Isoqov on 2/8/2023

fun Double.getFormat(count: Int): String {
    val formatterString = this.toString()
    val index = formatterString.indexOf('.')
    if (index != -1) {
        val dis = formatterString.lastIndex - index
        if (dis > count) {
            return formatterString.substring(0, index + count + 1)
        }
    }
    return formatterString
}