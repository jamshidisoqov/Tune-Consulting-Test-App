package uz.gita.tune_consulting.utils.extensions

import timber.log.Timber

// Created by Jamshid Isoqov on 12/12/2022


fun log(message: String, tag: String = "TTT") {
    Timber.tag(tag).d(message)
}
