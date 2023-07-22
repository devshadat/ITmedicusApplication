package com.devshadat.itmedicusapplication

import HomepageGridAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.devshadat.itmedicusapplication.entity.HomepageItem

class MainActivity : AppCompatActivity() {

    private lateinit var coursesGV: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                "https://images.immediate.co.uk/production/volatile/sites/3/2019/04/Avengers-Endgame-Banner-2-de7cf60.jpg?quality=90&resize=620,413"
            )
        )
        imageList.add(
            SlideModel(
                "https://img.cinemablend.com/filter:scale/quill/3/7/0/0/8/e/37008e36e98cd75101cf1347396eac8534871a19.jpg?mw=600"
            )
        )
        imageList.add(
            SlideModel(
                "https://www.adgully.com/img/800/201711/spider-man-homecoming-banner.jpg"
            )
        )
        imageList.add(
            SlideModel(
                "https://live.staticflickr.com/1980/29996141587_7886795726_b.jpg"
            )
        )

        imageSlider.setImageList(imageList, ScaleTypes.FIT)


        coursesGV = findViewById(R.id.homepage_grid)
        val courseModelArrayList: ArrayList<HomepageItem> = ArrayList<HomepageItem>()

        courseModelArrayList.add(HomepageItem("Product Brief", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Memo/Circular", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Digital WPM", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Survey", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Exam/Quiz", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Campaign", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Feedback", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Cycle Plan", R.drawable.product_brief))
        courseModelArrayList.add(HomepageItem("Notice", R.drawable.product_brief))

        val adapter = HomepageGridAdapter(this, courseModelArrayList)
        coursesGV.adapter = adapter

        // on below line we are adding on item
        // click listener for our grid view.
        coursesGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.
            when (position) {
                0 -> startActivity(Intent(this, ProductActivity::class.java))
                else -> Toast.makeText(this, "Feature is coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}