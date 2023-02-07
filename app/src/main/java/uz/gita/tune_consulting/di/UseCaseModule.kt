package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.tune_consulting.domain.useCase.AddCard
import uz.gita.tune_consulting.domain.useCase.GetAllCards
import uz.gita.tune_consulting.domain.useCase.IsAlreadyAddedCard
import uz.gita.tune_consulting.domain.useCase.impl.AddCardImpl
import uz.gita.tune_consulting.domain.useCase.impl.GetAllCardsImpl
import uz.gita.tune_consulting.domain.useCase.impl.IsAlreadyAddedCardImpl

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindAddCard(impl: AddCardImpl): AddCard

    @Binds
    fun bindGetAllCards(impl: GetAllCardsImpl): GetAllCards

    @Binds
    fun bindIsAlreadyAdded(impl: IsAlreadyAddedCardImpl): IsAlreadyAddedCard

}