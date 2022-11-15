package com.ao.example.presentation.ui.albumdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ao.example.databinding.AlbumPhotoItemBinding
import com.ao.example.domain.entity.AlbumPhoto
import com.ao.example.interfaces.OnItemClickListener
import com.ao.example.presentation.utils.loadImage

class AlbumPhotosListAdapter constructor(private val onItemClickListener: OnItemClickListener<AlbumPhoto>) :
    ListAdapter<AlbumPhoto, AlbumPhotosListAdapter.ViewHolder>(CountryListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AlbumPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: AlbumPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(albumPhoto: AlbumPhoto) {
            binding.apply {
                with(albumPhoto) {
                    albumImg.loadImage(url, null, progress)
                    albumImg.setOnClickListener {
                        onItemClickListener.onItemClicked(albumPhoto)
                    }
                }
            }
        }
    }


    class CountryListDiffCallback : DiffUtil.ItemCallback<AlbumPhoto>() {

        override fun areItemsTheSame(
            oldUser: AlbumPhoto,
            newUser: AlbumPhoto
        ): Boolean {
            return oldUser.id == newUser.id
        }

        override fun areContentsTheSame(
            oldUser: AlbumPhoto,
            newUser: AlbumPhoto
        ): Boolean {
            return oldUser == newUser
        }

    }

}