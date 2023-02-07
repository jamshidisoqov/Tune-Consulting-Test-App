package uz.gita.tune_consulting.utils.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// Created by Jamshid Isoqov on 12/12/2022

fun ViewGroup.inflate(resId: Int): View {
    return LayoutInflater.from(this.context).inflate(resId, this, false)
}