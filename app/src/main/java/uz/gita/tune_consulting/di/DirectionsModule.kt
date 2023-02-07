package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.tune_consulting.directions.SplashScreenDirection
import uz.gita.tune_consulting.directions.impl.SplashScreenDirectionImpl

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(ViewModelComponent::class)
interface DirectionsModule {

    @Binds
    fun bindSplashScreen(impl: SplashScreenDirectionImpl): SplashScreenDirection

}