package com.ao.example.presentation.ui.albumdetails

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.ao.example.R
import com.ao.example.databinding.FragmentAlbumDetailsBinding
import com.ao.example.domain.entity.AlbumPhoto
import com.ao.example.interfaces.OnItemClickListener
import com.ao.example.presentation.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.search_group.*

@AndroidEntryPoint
class AlbumDetailsFragment : Fragment(R.layout.fragment_album_details),
    OnItemClickListener<AlbumPhoto> {


    private val args: AlbumDetailsFragmentArgs by navArgs()
    private val viewModel: AlbumDetailsViewModel by viewModels()
    private var _binding: FragmentAlbumDetailsBinding? = null
    private val binding get() = _binding!!
    private val albumPhotosListAdapter by lazy {
        AlbumPhotosListAdapter(this@AlbumDetailsFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAlbumDetailsBinding.bind(view)

        setUpViews()
        setObservers()

    }

    private fun setUpViews() {
        viewModel.getUserDetails(args.albumId)
        binding.apply {
            albumName.text = args.albumTitle
            progressCircular.visibility = View.VISIBLE
            albumsRecycler.apply {
                adapter = albumPhotosListAdapter
                layoutManager = GridLayoutManager(activity, 3)
                itemAnimator = null
            }

            search_field.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.filterAlbumPhotos(p0.toString())
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })

            search_field.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.filterAlbumPhotos(search_field.text.toString())
                    return@OnEditorActionListener true
                }
                false
            })

        }


    }

    private fun setObservers() {

        viewModel.usersAlbums.observe(viewLifecycleOwner) { users ->
            when (users.status.get()) {
                Status.LOADING -> {
                    binding.progressCircular.visible()
                }
                Status.ERROR -> {
                    binding.progressCircular.invisible()
                    users.msg?.let {
                        if (it == getString(R.string.msg_network_error))
                            no_internet_layout.visible()
                        showSnackBar(it)
                    }
                }
                Status.SUCCESS -> {
                    binding.albumName.visible()
                    binding.progressCircular.invisible()
                    users.data?.let {
                        if (it.isNullOrEmpty() && viewModel.emptyFilterMessage.value.isNullOrEmpty())
                            showSnackBar(getString(R.string.no_album_photos_for_user))
                        albumPhotosListAdapter.submitList(it)
                        albumPhotosListAdapter.notifyDataSetChanged()
                    }
                }
            }
        }

        viewModel.emptyFilterMessage.observe(viewLifecycleOwner) { msg ->
            if (!msg.isNullOrEmpty()) {
                showToast(msg)
            }
        }
    }

    override fun onItemClicked(item: AlbumPhoto) {
        findNavController().navigate(
            AlbumDetailsFragmentDirections.actionAlbumDetailsFragmentToZoomImageFragment(
                item.title, item.url
            )
        )
    }

    private fun showSnackBar(message: String) {
        binding.main.snack(message) {}
    }

    private fun showToast(message: String) {
        requireActivity().toast(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}