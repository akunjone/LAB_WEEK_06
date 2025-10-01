package com.example.lab_week_06

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.lab_week_06.CatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import com.example.lab_week_06.ImageLoader

class MainActivity : AppCompatActivity() {
    private val imageLoader: ImageLoader = GlideImageLoader(this)
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
    //Glide is used here to load the images
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener{
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.DomesticShorthair,
                    "Tom",
                    "Always chasing Jerry",
                    "https://cdn2.thecatapi.com/images/acd.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BurmeseCat,
                    "Luna",
                    "Loves moonlight naps",
                    "https://cdn2.thecatapi.com/images/aaa.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Birman,
                    "Simba",
                    "The little lion king",
                    "https://cdn2.thecatapi.com/images/ab1.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Ragdoll,
                    "Milo",
                    "Playful and curious",
                    "https://cdn2.thecatapi.com/images/60g.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ScottishFold,
                    "Nala",
                    "Brave and kind",
                    "https://cdn2.thecatapi.com/images/a80.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.TurkishAngora,
                    "Oscar",
                    "Lazy and cuddly",
                    "https://cdn2.thecatapi.com/images/ba8.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Korat,
                    "Cleo",
                    "Elegant and mysterious",
                    "https://cdn2.thecatapi.com/images/a80.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.HimalayanCat,
                    "Bordi",
                    "Cute and powerful",
                    "https://cdn2.thecatapi.com/images/ab2.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel){
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") {_, _, ->}.show()
    }
}
