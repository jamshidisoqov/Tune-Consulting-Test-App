package uz.gita.tune_consulting.utils.extensions

import kotlinx.coroutines.flow.SharedFlow

// Created by Jamshid Isoqov on 2/8/2023
interface BaseViewModel {

    val loadingFlow: SharedFlow<Boolean>

    val networkConnectionError: SharedFlow<String>

    val errorFlow: SharedFlow<Throwable>

    val messageFlow: SharedFlow<String>

}