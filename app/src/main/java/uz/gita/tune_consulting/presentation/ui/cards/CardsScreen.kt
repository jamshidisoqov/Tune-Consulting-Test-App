package uz.gita.tune_consulting.presentation.ui.cards

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.tune_consulting.R
import uz.gita.tune_consulting.databinding.ScreenCardsBinding
import uz.gita.tune_consulting.presentation.presenter.CardsViewModelImpl
import uz.gita.tune_consulting.utils.extensions.include
import uz.gita.tune_consulting.utils.extensions.showToast
import uz.gita.tune_consulting.utils.tabList

// Created by Jamshid Isoqov on 2/7/2023
@AndroidEntryPoint
class CardsScreen : Fragment(R.layout.screen_cards) {

    private val viewBinding: ScreenCardsBinding by viewBinding()

    private val viewModel: CardsViewModel by viewModels<CardsViewModelImpl>()

    @SuppressLint("NotifyDataSetChanged")
    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {

        pagerCards.adapter = CardsPagerAdapter(requireActivity())

        TabLayoutMediator(cardTabs, pagerCards) { tab, position ->
            tab.text = tabList[position]
        }.attach()


        viewBinding.imageBack
            .clicks()
            .debounce(300L)
            .onEach {
                showToast("Back")
            }.launchIn(lifecycleScope)

        viewBinding.imageAddCard
            .clicks()
            .debounce(300L)
            .onEach {
                viewModel.navigateToAddCards()
            }.launchIn(lifecycleScope)

        viewBinding.imageRefresh
            .clicks()
            .debounce(300L)
            .onEach {
                pagerCards.adapter?.notifyDataSetChanged()
            }.launchIn(lifecycleScope)


    }

}