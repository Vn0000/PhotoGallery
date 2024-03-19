package com.vn000.android.photogallery.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vn000.android.photogallery.R
import com.vn000.android.photogallery.api.FlickrApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "PhotoGalleryFragment"

class PhotoGalleryFragment : Fragment() {

    private lateinit var phoRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_photo_gallery, container, false
        )
        phoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        phoRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val flickerApi: FlickrApi = retrofit.create(FlickrApi::class.java)
        val flickerHomePageRequest: Call<String> = flickerApi.fetchContents()
        flickerHomePageRequest.enqueue(object : Callback<String> {

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d(
                    TAG, "Failed to fetch\n" +
                            "photos", t
                )
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(
                    TAG, "Response received:\n" +
                            "${response.body()}"
                )
            }
        })
    }

    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }
}
