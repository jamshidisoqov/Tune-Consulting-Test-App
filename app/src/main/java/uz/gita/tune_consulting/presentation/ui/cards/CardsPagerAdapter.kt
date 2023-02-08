package uz.gita.tune_consulting.presentation.ui.cards

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.tune_consulting.presentation.ui.cards.page.CardsPage
import uz.gita.tune_consulting.utils.tabList

// Created by Jamshid Isoqov on 2/8/2023
class CardsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment = CardsPage()

}