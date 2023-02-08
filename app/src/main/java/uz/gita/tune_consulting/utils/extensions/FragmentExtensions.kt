package uz.gita.tune_consulting.utils.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.gita.tune_consulting.presentation.ui.dialogs.ConnectionErrorDialog
import uz.gita.tune_consulting.presentation.ui.dialogs.ErrorDialog
import uz.gita.tune_consulting.presentation.ui.dialogs.MessageDialog

// Created by Jamshid Isoqov on 2/8/2023


fun Fragment.showErrorDialog(message: String) {
    val dialog = ErrorDialog(requireContext(), message)
    dialog.show()
}

fun Fragment.showMessageDialog(message: String) {
    val dialog = MessageDialog(requireContext(), message)
    dialog.show()
}

fun Fragment.showConnectionError(message: String, onRetry: () -> Unit) {
    val dialog = ConnectionErrorDialog(message = message, ctx = requireContext())
    dialog.setDismissListener(onRetry)
    dialog.show()
}

fun Fragment.showToast(message: String){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}