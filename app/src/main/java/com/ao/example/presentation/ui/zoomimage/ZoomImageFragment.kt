package com.ao.example.presentation.ui.zoomimage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ao.example.R
import com.ao.example.databinding.FragmentZoomImageBinding
import com.ao.example.presentation.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ZoomImageFragment : Fragment(R.layout.fragment_zoom_image) {

    private val args: ZoomImageFragmentArgs by navArgs()
    private var _binding: FragmentZoomImageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentZoomImageBinding.bind(view)

        setUpViews()
    }


    private fun setUpViews() {
        binding.imageTitle.text = args.albumTitle
       // binding.imageView.loadImage(args.albumUrl, null, binding.progress)
        binding.share.setOnClickListener {

            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
                var shareMessage = getString(R.string.recommendation_msg)
                shareMessage += args.albumUrl;
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (e: Exception) {

            }
        }

        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}