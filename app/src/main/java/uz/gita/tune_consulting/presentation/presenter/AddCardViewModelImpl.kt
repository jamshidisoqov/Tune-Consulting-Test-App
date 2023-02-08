package uz.gita.tune_consulting.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.tune_consulting.domain.useCase.AddCardUseCase
import uz.gita.tune_consulting.domain.useCase.IsAlreadyAddedCardUseCase
import uz.gita.tune_consulting.presentation.ui.cards.add.AddCardViewModel
import uz.gita.tune_consulting.utils.hasConnection
import javax.inject.Inject

@HiltViewModel
class AddCardViewModelImpl @Inject constructor(
    private val addCardUseCase: AddCardUseCase,
    private val isAlreadyAddedCardUseCase: IsAlreadyAddedCardUseCase
) : AddCardViewModel, ViewModel() {

    override val loadingFlow = MutableSharedFlow<Boolean>()

    override val networkConnectionError = MutableSharedFlow<String>()

    override val errorFlow = MutableSharedFlow<Throwable>()

    override val messageFlow = MutableSharedFlow<String>()

    override val successFlow = MutableSharedFlow<Unit>()

    override fun addCard(cardNumber: String, cardExpiredDate: Long) {
        viewModelScope.launch {
            if (hasConnection()) {
                loadingFlow.emit(true)
                isAlreadyAddedCardUseCase.isAlreadyCard(cardNumber, cardExpiredDate.toString())
                    .collectLatest { result ->
                        result.onSuccess {
                            addCardUseCase.addCard(cardNumber, cardExpiredDate.toString())
                                .collectLatest { result ->
                                    loadingFlow.emit(false)
                                    result.onSuccess {
                                        successFlow.emit(Unit)
                                    }.onMessage {
                                        messageFlow.emit(it)
                                    }.onError {
                                        errorFlow.emit(it)
                                    }
                                }
                        }.onMessage {
                            loadingFlow.emit(false)
                            messageFlow.emit(it)
                        }.onError {
                            loadingFlow.emit(false)
                            errorFlow.emit(it)
                        }
                    }
            } else {
                networkConnectionError.emit("No internet connection")
            }
        }
    }
}