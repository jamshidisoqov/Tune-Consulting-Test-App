package uz.gita.tune_consulting.presentation.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import uz.gita.tune_consulting.R
import uz.gita.tune_consulting.databinding.ScreenSplashBinding
import uz.gita.tune_consulting.presentation.presenter.SplashViewModelImpl
import uz.gita.tune_consulting.utils.extensions.include

// Created by Jamshid Isoqov on 2/7/2023
@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    private val viewBinding: ScreenSplashBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = viewBinding.include {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            delay(1000)
            viewModel.navigateToCards()
        }
    }
}