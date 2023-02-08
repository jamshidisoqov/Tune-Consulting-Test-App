package uz.gita.tune_consulting.directions.impl

import uz.gita.tune_consulting.directions.CardsScreenDirection
import uz.gita.tune_consulting.navigation.Navigator
import uz.gita.tune_consulting.presentation.ui.cards.CardsScreenDirections
import javax.inject.Inject

class CardsScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : CardsScreenDirection {
    override suspend fun navigateToAddCard() {
        navigator.navigateTo(CardsScreenDirections.actionCardsScreenToAddCardScreen())
    }
}