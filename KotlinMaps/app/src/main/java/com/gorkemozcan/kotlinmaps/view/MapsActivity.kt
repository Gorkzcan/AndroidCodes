package com.gorkemozcan.kotlinmaps.view

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Room

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.gorkemozcan.kotlinmaps.R
import com.gorkemozcan.kotlinmaps.databinding.ActivityMapsBinding
import com.gorkemozcan.kotlinmaps.model.Place
import com.gorkemozcan.kotlinmaps.roomdb.PlaceDao
import com.gorkemozcan.kotlinmaps.roomdb.PlaceDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var sharedPreferences: SharedPreferences
    private var trackBoolean : Boolean? = null
    private var selectedLatitude : Double? = null
    private var selectedLongitude : Double? = null
    private lateinit var db : PlaceDatabase
    private lateinit var placeDao : PlaceDao
    val compositeDisposable = CompositeDisposable() // kullan at - tek kullan??ml??k.
    var placeFromMain : Place? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        registerLauncher()
        sharedPreferences = this.getSharedPreferences("com.gorkemozcan.kotlinmaps", MODE_PRIVATE)
        trackBoolean = false
        selectedLatitude = 0.0
        selectedLongitude = 0.0
        db = Room.databaseBuilder(applicationContext,PlaceDatabase::class.java, "Places")
            //.allowMainThreadQueries()
            .build() //places ismi her yerde ayn?? olmal?? veritaban??n??n ismidir.
        placeDao = db.placeDao()
        binding.saveButton.isEnabled = false

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLongClickListener(this)


        val intent = intent
        val info = intent.getStringExtra("info")

        if(info == "new")
        {
            binding.saveButton.visibility = View.VISIBLE
            binding.deleteButton.visibility = View.GONE

            //casting
            locationManager =
                this.getSystemService(LOCATION_SERVICE) as LocationManager // bunu location manager olarak kaydetmek istiyorum ve eminim diyoruz
            locationListener = object : LocationListener {
                override fun onLocationChanged(p0: Location) {
                    //println("Location : "+p0.toString())
                    trackBoolean = sharedPreferences.getBoolean("trackBoolean", false) // e??er kay??tl?? de??ilse ilk de??er false olacak
                    if(trackBoolean == false)
                    {
                        val userLocation = LatLng(p0.latitude, p0.longitude)
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15f))
                        sharedPreferences.edit().putBoolean("trackBoolean", true).apply()
                        //uygulama a????ld??????nda false de??er d??nd??yse ilk konumu alacak ve sharedPereferences i??erisine kay??t edecek ve true yapacak.
                        //art??k de??er true oldu??undan tekrar ??al????mayacak
                    }
                }

            }
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //izin yok
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    Snackbar.make(
                        binding.root,
                        "Permission Needed For Location",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("Give Permission") {
                        //request permission
                        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)

                    }.show()
                } else {
                    //request permission
                    permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            } else {
                //izin var
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0f,
                    locationListener
                )
                val lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (lastLocation != null) {

                    val lastUserLocation = LatLng(lastLocation.latitude, lastLocation.longitude)
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastUserLocation, 15f))
                }
                mMap.isMyLocationEnabled = true // benim konumumu etkinle??tirdik mi ? -> izin varsa yapabiliyoruz.


            }
        }
        else{
            mMap.clear()
            placeFromMain = intent.getSerializableExtra("selectedPlace") as? Place
            placeFromMain?.let {
                val latlng = LatLng(it.latitude,it.longitude)
                mMap.addMarker(MarkerOptions().position(latlng).title(it.name))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f))
                binding.placeText.setText(it.name)
                binding.saveButton.visibility = View.GONE
                binding.deleteButton.visibility = View.VISIBLE
            }


        }



/*
    //Latitude -> enlem
        //Longitude -> boylam
        //LatLng -> latitude Longitude
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

 */
    }

    private fun registerLauncher() {
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                if (result) {

                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        //permission granted
                        locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0,
                            0f,
                            locationListener
                        )
                        val lastLocation =
                            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                        if (lastLocation != null) {

                            val lastUserLocation = LatLng(lastLocation.latitude, lastLocation.longitude)
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastUserLocation, 15f))
                        }

                    } else {
                        //permission denied
                        Toast.makeText(this@MapsActivity, "Permission Needed!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
    }

    override fun onMapLongClick(p0: LatLng) {
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(p0))
        selectedLatitude = p0.latitude
        selectedLongitude = p0.longitude

        binding.saveButton.isEnabled = true

    }


    fun delete(view: View){
        placeFromMain?.let {
            compositeDisposable.add(
                placeDao.delete(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse)
            )
        }



    }
    fun save(view: View){

        //Main Thread UI, Default -> CPU , IO -> input output -> internetten veri ??ekerken kullan??l??yor Retrofit gibi./Database i??lemleride oluyor burda IO kullan??lacak. Corutines veya Rxjava kullan??l??yor.

        if(selectedLatitude != null && selectedLongitude != null) {
            val place = Place(binding.placeText.text.toString(), selectedLatitude!!, selectedLongitude!!)
            compositeDisposable.add(
                placeDao.insert(place)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse) //bitince handleresponse ??al????acak.
            )
        }
    }
    private fun handleResponse(){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.clear()
    }
}


