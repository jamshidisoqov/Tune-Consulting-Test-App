package uz.gita.tune_consulting.presentation.ui.cards.add

import kotlinx.coroutines.flow.SharedFlow
import uz.gita.tune_consulting.utils.extensions.BaseViewModel

// Created by Jamshid Isoqov on 2/8/2023
interface AddCardViewModel : BaseViewModel {

    val successFlow:SharedFlow<Unit>

    fun addCard(cardNumber:String,cardExpiredDate:Long)

}