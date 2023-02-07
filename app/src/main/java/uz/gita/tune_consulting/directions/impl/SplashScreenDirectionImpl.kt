package uz.gita.tune_consulting.directions.impl

import uz.gita.tune_consulting.directions.SplashScreenDirection
import uz.gita.tune_consulting.navigation.Navigator
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : SplashScreenDirection {
    override suspend fun navigateToCards() {

    }
}