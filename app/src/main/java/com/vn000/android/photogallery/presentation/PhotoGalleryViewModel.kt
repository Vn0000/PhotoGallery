package com.vn000.android.photogallery.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vn000.android.photogallery.api.FlickrFetchr
import com.vn000.android.photogallery.data.GalleryItem

class PhotoGalleryViewModel : ViewModel() {
    val galleryItemLiveData: LiveData<List<GalleryItem>>
    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }
}
