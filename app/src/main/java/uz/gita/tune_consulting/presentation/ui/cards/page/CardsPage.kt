package uz.gita.tune_consulting.presentation.ui.cards.page

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.tune_consulting.R
import uz.gita.tune_consulting.databinding.PageCardsBinding
import uz.gita.tune_consulting.presentation.presenter.CardPageViewModelImpl
import uz.gita.tune_consulting.utils.extensions.*

// Created by Jamshid Isoqov on 2/7/2023
@AndroidEntryPoint
class CardsPage : Fragment(R.layout.page_cards) {

    private val viewBinding: PageCardsBinding by viewBinding()

    private val viewModel: CardPageViewModel by viewModels<CardPageViewModelImpl>()

    private val adapter: CardsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        CardsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        listCards.adapter = adapter

        viewModel.loadingFlow.onEach {
            if (it) {
                shimmerLayout.visible()
                shimmerLayout.startShimmer()
                listCards.gone()
            } else {
                shimmerLayout.gone()
                shimmerLayout.stopShimmer()
                listCards.visible()
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.messageFlow.onEach {
            showMessageDialog(it)
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            showErrorDialog(it.getMessage())
        }.launchIn(lifecycleScope)

        viewModel.networkConnectionError.onEach {
            showConnectionError(it){
                viewModel.getAllCards()
            }
        }.launchIn(lifecycleScope)

        viewModel.allCardsFlow.onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.getAllCards()

    }


}