package com.example.lab_week_06

import com.example.lab_week_06.model.Gender
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.getValue



class CatViewHolder(
    private val containerView: View,
    private  val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
): RecyclerView.ViewHolder(containerView){
    private val FEMALE_SYMBOL = "\u2640"
    private val MALE_SYMBOL = "\u2642"
    private val UNKNOWN_SYMBOL = "?"
    //class CatViewHolder private constructor(containerView: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(containerView) {
    //containerView is the container layout of each item list
    //Here findViewById is used to get the reference of each views inside the container
    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography)
    }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed)
    }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender)
    }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name)
    }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo)
    }

    //This function is called in the adapter to provide the binding function
    fun bindData(cat: CatModel) {
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }

    interface OnClickListener{
        fun onClick(cat: CatModel)
    }
}
