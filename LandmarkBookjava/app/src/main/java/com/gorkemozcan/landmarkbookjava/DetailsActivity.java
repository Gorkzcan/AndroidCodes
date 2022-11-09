package com.gorkemozcan.landmarkbookjava;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gorkemozcan.landmarkbookjava.databinding.ActivityDetailsBinding;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //inflate -> xml ile kodumuzu bağlamaya çalıştığımmız yer
        Intent intent = getIntent();

        Singleton singleton = Singleton.getInstance();
        Landmark selectedLandmark = singleton.getSentLandmark();


        //casting bişeyi bişeye dönüştürmek
        //Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("Landmark");
        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);
    }
}
