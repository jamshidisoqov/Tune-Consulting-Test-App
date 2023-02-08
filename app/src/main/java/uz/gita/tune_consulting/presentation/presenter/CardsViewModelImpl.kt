package uz.gita.tune_consulting.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.tune_consulting.directions.CardsScreenDirection
import uz.gita.tune_consulting.presentation.ui.cards.CardsViewModel
import javax.inject.Inject

@HiltViewModel
class CardsViewModelImpl @Inject constructor(
    private val direction: CardsScreenDirection
) : CardsViewModel, ViewModel() {
    override fun navigateToAddCards() {
        viewModelScope.launch {
            direction.navigateToAddCard()
        }
    }
}