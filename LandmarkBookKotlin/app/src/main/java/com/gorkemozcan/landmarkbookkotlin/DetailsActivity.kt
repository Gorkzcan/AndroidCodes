package com.gorkemozcan.landmarkbookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gorkemozcan.landmarkbookkotlin.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //Casting

       // val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark

        //val selectedLandmark = chosenLandmark
        /*
        binding.nameText.text = selectedLandmark!!.name
        binding.countryText.text = selectedLandmark!!.country
        binding.imageView.setImageResource(selectedLandmark!!.image)

         */
        val selectedLandmark = mySingleton.chosenLandmark
        selectedLandmark?.let {
            binding.nameText.text = it.name
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
        }


    }
}