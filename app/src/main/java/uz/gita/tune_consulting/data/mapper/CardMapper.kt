package uz.gita.tune_consulting.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest

// Created by Jamshid Isoqov on 2/7/2023
fun DocumentSnapshot.toCardResponse(): CardResponse =
    CardResponse(
        id = this.id,
        cardNumber = this["cardNumber"].toString(),
        cardExpiredDate = this["cardExpiredDate"].toString()
    )

fun CardRequest.toCardResponse(cardId: String): CardResponse =
    CardResponse(
        id = cardId,
        cardNumber = cardNumber,
        cardExpiredDate = cardExpiredDate
    )