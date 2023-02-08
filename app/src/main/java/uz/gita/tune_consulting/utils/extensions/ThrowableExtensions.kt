package uz.gita.tune_consulting.utils.extensions

// Created by Jamshid Isoqov an 10/12/2022
fun Throwable.getMessage() = this.message ?: "Неизвестная ошибка"
