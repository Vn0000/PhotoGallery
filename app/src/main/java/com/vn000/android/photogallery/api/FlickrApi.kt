package com.vn000.android.photogallery.api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi  {
    @GET("services/rest/?method=flickr.interestingness.getList"+
        "&api_key=ea9864f0da4c5a0c5627af08b9ea164e"+
                "&format=json"+
                "&nojsoncallback=1"+
                "&extras=url_s")
    fun  fetchPhotos(): Call<FlickrResponse>
}