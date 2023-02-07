package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tune_consulting.navigation.NavigationDispatcher
import uz.gita.tune_consulting.navigation.NavigationHandler
import uz.gita.tune_consulting.navigation.Navigator
import javax.inject.Singleton

// Created by Jamshid Isoqov on 12/12/2022
@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun navigator(dispatcher: NavigationDispatcher): Navigator

    @[Binds Singleton]
    fun navigatorHandler(dispatcher: NavigationDispatcher): NavigationHandler

}