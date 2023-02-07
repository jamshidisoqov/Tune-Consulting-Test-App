package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.domain.repository.impl.CardRepositoryImpl
import javax.inject.Singleton

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindCardRepository(impl:CardRepositoryImpl):CardRepository

}