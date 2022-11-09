package com.gorkemozcan.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.gorkemozcan.landmarkbookjava.databinding.ActivityDetailsBinding;
import com.gorkemozcan.landmarkbookjava.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    //static Landmark chosenLandmark; //statik oluşturduğumuz değişkenlere her yerden ulaşabiliriz.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        //data
        Landmark pisa = new Landmark("Pisa Tower", "Italy", R.drawable.pisa);
        Landmark colosseum = new Landmark("Colosseum", "Italy", R.drawable.colosseum);
        Landmark eiffel = new Landmark("Eiffel Tower", "France", R.drawable.eiffel);
        Landmark londonBridge = new Landmark("London Bridge", "England", R.drawable.londonbridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


        /*
        Bu kısımda listView kullanımı gösterilmiştir.
        //Adapter -> veri kaynağımızla xml ve listView'i birbirine bağlayan yapıdır.
        //listView ->verimsiz
        //mapping -> haritalamak, bir şeyi başka bir şeye dönüştürmede kullanıyoruz. landmark'ı landmark.name'e çevirdik.
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, landmarkArrayList.get(i).name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Landmark", landmarkArrayList.get(i));
                startActivity(intent);
            }
        });

*/
        //recyclerView Adapter sınıfı kendine aittir. Ve bunu biz yazıyoruz.


    }


}