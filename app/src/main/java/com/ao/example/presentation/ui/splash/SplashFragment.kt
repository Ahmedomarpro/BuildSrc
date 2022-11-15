package com.ao.example.presentation.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ao.example.R
import com.ao.example.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        setUpViews()
    }


    private fun setUpViews() {
       requireActivity(). window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            findNavController().navigate(
                SplashFragmentDirections.actionNavigationSplashToProfileFragment()
            )
        }, 1000)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}