package com.devshadat.itmedicusapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://images.immediate.co.uk/production/volatile/sites/3/2019/04/Avengers-Endgame-Banner-2-de7cf60.jpg?quality=90&resize=620,413"))
        imageList.add(SlideModel("https://img.cinemablend.com/filter:scale/quill/3/7/0/0/8/e/37008e36e98cd75101cf1347396eac8534871a19.jpg?mw=600"))
        imageList.add(SlideModel("https://www.adgully.com/img/800/201711/spider-man-homecoming-banner.jpg"))
        imageList.add(SlideModel("https://live.staticflickr.com/1980/29996141587_7886795726_b.jpg"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}