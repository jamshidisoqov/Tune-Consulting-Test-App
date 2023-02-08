package uz.gita.tune_consulting.presentation.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import uz.gita.tune_consulting.databinding.DialogConnectionErrorBinding
import uz.gita.tune_consulting.utils.extensions.config

// Created by Jamshid Isoqov on 2/8/2023
class ConnectionErrorDialog(ctx: Context, private val message: String) : Dialog(ctx) {

    private lateinit var viewBinding: DialogConnectionErrorBinding

    private var dismissListener: (() -> Unit)? = null

    fun setDismissListener(block: () -> Unit) {
        dismissListener = block
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = DialogConnectionErrorBinding.inflate(layoutInflater)
        config(viewBinding)
        viewBinding.tvErrorMessage.text = message
        setCancelable(false)
        viewBinding.btnRetry.setOnClickListener {
            dismissListener?.invoke()
            dismiss()
        }
    }


}