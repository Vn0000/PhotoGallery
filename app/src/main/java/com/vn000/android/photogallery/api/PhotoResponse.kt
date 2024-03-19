package com.vn000.android.photogallery.api

import com.google.gson.annotations.SerializedName
import com.vn000.android.photogallery.data.GalleryItem

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}
