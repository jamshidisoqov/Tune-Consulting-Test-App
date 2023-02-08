package uz.gita.tune_consulting.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.domain.useCase.GetAllCards
import uz.gita.tune_consulting.presentation.ui.cards.page.CardPageViewModel
import uz.gita.tune_consulting.utils.hasConnection
import javax.inject.Inject

@HiltViewModel
class CardPageViewModelImpl @Inject constructor(
    private val getAllCards: GetAllCards
) : CardPageViewModel, ViewModel() {

    override val allCardsFlow: MutableStateFlow<List<CardResponse>> = MutableStateFlow(emptyList())

    override val loadingFlow = MutableSharedFlow<Boolean>()

    override val networkConnectionError = MutableSharedFlow<String>()

    override val errorFlow = MutableSharedFlow<Throwable>()

    override val messageFlow = MutableSharedFlow<String>()

    override fun getAllCards() {
        viewModelScope.launch {
            if (hasConnection()) {
                loadingFlow.emit(true)
                getAllCards.getAllCards()
                    .collectLatest { result ->
                        loadingFlow.emit(false)
                        result.onSuccess {
                            allCardsFlow.emit(it)
                        }.onMessage {
                            messageFlow.emit(it)
                        }.onError {
                            errorFlow.emit(it)
                        }
                    }
            } else {
                networkConnectionError.emit("No internet connection")
            }
        }
    }
}