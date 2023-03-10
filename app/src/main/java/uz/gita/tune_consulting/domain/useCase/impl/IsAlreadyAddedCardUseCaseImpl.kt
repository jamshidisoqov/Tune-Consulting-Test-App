package uz.gita.tune_consulting.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.domain.useCase.IsAlreadyAddedCardUseCase
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class IsAlreadyAddedCardUseCaseImpl @Inject constructor(
    private val cardRepository: CardRepository
) : IsAlreadyAddedCardUseCase {
    override fun isAlreadyCard(
        cardNumber: String,
        cardExpiredDate: String
    ): Flow<ResultData<Unit>> =
        cardRepository.isAlreadyAddedCard(CardRequest(cardNumber, cardExpiredDate))
}