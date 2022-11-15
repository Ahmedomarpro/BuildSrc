package com.ao.example.data.api.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumResponse (
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
): Parcelable