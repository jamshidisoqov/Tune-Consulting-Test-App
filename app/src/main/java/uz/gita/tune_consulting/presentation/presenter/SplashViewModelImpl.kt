package uz.gita.tune_consulting.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.tune_consulting.directions.SplashScreenDirection
import uz.gita.tune_consulting.presentation.ui.splash.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
private val direction: SplashScreenDirection
) : SplashViewModel,ViewModel() {
    override fun navigateToCards() {
        viewModelScope.launch {
            direction.navigateToCards()
        }
    }
}