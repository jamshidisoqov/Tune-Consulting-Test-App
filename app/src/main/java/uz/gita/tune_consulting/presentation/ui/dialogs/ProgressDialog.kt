package uz.gita.tune_consulting.presentation.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import uz.gita.tune_consulting.databinding.DialogProgressBinding

// Created by Jamshid Isoqov an 10/12/2022
class ProgressDialog(ctx: Context) : Dialog(ctx) {

    private lateinit var binging: DialogProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binging = DialogProgressBinding.inflate(layoutInflater)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binging.root)
        setCancelable(false)
    }

}