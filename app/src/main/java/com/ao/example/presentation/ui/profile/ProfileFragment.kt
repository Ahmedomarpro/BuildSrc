package com.ao.example.presentation.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ao.example.R
import com.ao.example.databinding.FragmentProfileBinding
import com.ao.example.domain.entity.Album
import com.ao.example.interfaces.OnItemClickListener
import com.ao.example.presentation.utils.Status
import com.ao.example.presentation.utils.invisible
import com.ao.example.presentation.utils.snack
import com.ao.example.presentation.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_profile.*

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile), OnItemClickListener<Album> {

    private val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val albumsListAdapter by lazy {
        AlbumsListAdapter(this@ProfileFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        setUpViews()
        setObservers()
    }


    private fun setUpViews() {
        viewModel.getUserDetails()
        binding.apply {
            progressCircular.visibility = View.VISIBLE
            albumsRecycler.apply {
                adapter = albumsListAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                itemAnimator = null
                addItemDecoration(
                    DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)
                )
            }
        }


    }

    private fun setObservers() {

        viewModel.users.observe(viewLifecycleOwner) { users ->
            when (users.status.get()) {
                Status.LOADING -> {
                    binding.progressCircular.visible()
                }
                Status.ERROR -> {
                    binding.progressCircular.invisible()
                    users.msg?.let {
                      //  if (it == getString(R.string.msg_network_error))
                            no_internet_layout.visible()
                        showSnackBar(it)
                    }
                }
                Status.SUCCESS -> {
                    binding.progressCircular.invisible()
                    Toast.makeText(context, ""+users.data?.name, Toast.LENGTH_SHORT).show()
                    users.data?.let {
                        with(it) {
                            binding.name.text = name
                            binding.address.text = address
                        }
                    }
                }
                null -> TODO()
            }
        }

        viewModel.usersAlbums.observe(viewLifecycleOwner) { users ->
            when (users.status.get()) {
                Status.LOADING -> {
                    binding.progressCircular.visible()
                }
                Status.ERROR -> {
                    binding.progressCircular.invisible()
                    users.msg?.let {
                        showSnackBar(it)
                    }
                }
                Status.SUCCESS -> {
                    binding.progressCircular.invisible()
                    users.data?.let {
                        if (it.isNullOrEmpty())
                         //   showSnackBar(getString(R.string.no_albums_for_user))
                        else {
                            binding.albumsLabel.visible()
                            albumsListAdapter.submitList(it)
                        }
                    }
                }
                null -> TODO()
            }
        }
    }

    override fun onItemClicked(item: Album) {
        findNavController().navigate(
            ProfileFragmentDirections.actionProfileFragmentToAlbumDetailsFragment(
                item.title, item.id
            )
        )
    }

    private fun showSnackBar(message: String) {
        binding.main.snack(message) {}
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

