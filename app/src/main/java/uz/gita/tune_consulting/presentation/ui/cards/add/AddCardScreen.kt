package uz.gita.tune_consulting.presentation.ui.cards.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import ru.ldralighieri.corbind.widget.textChanges
import uz.gita.tune_consulting.R
import uz.gita.tune_consulting.databinding.ScreenAddCardBinding
import uz.gita.tune_consulting.presentation.presenter.AddCardViewModelImpl
import uz.gita.tune_consulting.presentation.ui.dialogs.ChooseDateDialog
import uz.gita.tune_consulting.presentation.ui.dialogs.ProgressDialog
import uz.gita.tune_consulting.utils.extensions.*
import java.util.*

// Created by Jamshid Isoqov on 2/7/2023
@AndroidEntryPoint
class AddCardScreen : Fragment(R.layout.screen_add_card) {

    private val viewModel: AddCardViewModel by viewModels<AddCardViewModelImpl>()

    private val viewBinding: ScreenAddCardBinding by viewBinding()

    private var expiredDate = System.currentTimeMillis()

    private lateinit var dialog: ProgressDialog

    private var boolCardNumber = false
    private var boolDate = false

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        viewBinding.include {

            dialog = ProgressDialog(requireContext())

            viewModel.loadingFlow.onEach {
                if (it) {
                    dialog.show()
                } else {
                    dialog.dismiss()
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)

            viewModel.messageFlow.onEach {
                showMessageDialog(it)
            }.launchIn(lifecycleScope)

            viewModel.errorFlow.onEach {
                showErrorDialog(it.getMessage())
            }.launchIn(lifecycleScope)

            viewModel.networkConnectionError.onEach {
                showConnectionError(it) {
                    addCard(inputCardNumber.text.toString(), expiredDate)
                }
            }.launchIn(lifecycleScope)

            viewModel.successFlow.onEach {
                findNavController().navigateUp()
            }.launchIn(lifecycleScope)

            inputCardNumber.textChanges()
                .debounce(200L)
                .onEach {
                    boolCardNumber = it.length == 19
                    check()
                }.launchIn(viewLifecycleOwner.lifecycleScope)

            inputCardExpiredDate.clicks()
                .debounce(200L)
                .onEach {
                    val dialog = ChooseDateDialog(requireContext(), Date(expiredDate))
                    dialog.setConfirmClickListener {
                        expiredDate = it.time
                        inputCardExpiredDate.setText(it.time.toDateFormat())
                        if (!boolDate) {
                            boolDate = true
                            check()
                        }
                    }
                    dialog.show()
                }.launchIn(lifecycleScope)

            imageBack.clicks()
                .debounce(200L)
                .onEach {
                    findNavController().navigateUp()
                }.launchIn(lifecycleScope)

            btnAddCard.clicks()
                .debounce(200L)
                .onEach {
                    addCard(inputCardNumber.text.toString(), expiredDate)
                }.launchIn(lifecycleScope)

        }

    private fun addCard(cardNumber: String, cardExpired: Long) {
        viewModel.addCard(cardNumber, cardExpired)
    }

    private fun check() {
        viewBinding.btnAddCard.isEnabled = boolCardNumber && boolDate
    }
}