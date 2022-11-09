package com.gorkemozcan.catchgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.gorkemozcan.catchgame.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable{}
    lateinit var sharedPreferences: SharedPreferences
    var lastScore: Int? = null
    var highScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences =
            this.getSharedPreferences("com.gorkemozcan.catchgame", Context.MODE_PRIVATE)
        lastScore = sharedPreferences.getInt("lastScore", 0)
        highScore = sharedPreferences.getInt("highScore", 0)

        if(lastScore == 0)
            binding.lastScoreText.text = "Last Score: "
        else
            binding.lastScoreText.text = "Last Score: "+lastScore
        if (highScore==0)
            binding.highScoreText.text = "High Score: 0"
        else
            binding.highScoreText.text = "High Score: "+highScore



        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        hideImages()

        object: CountDownTimer(16000, 1000)
        {
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time: "+p0/1000
            }

            override fun onFinish() {
                binding.timeText.text = "Time: 0"
                handler.removeCallbacks(runnable)
                for(i in imageArray)
                    i.visibility = View.INVISIBLE
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over !")
                alert.setMessage("Restart?")
                alert.setPositiveButton("Yes") {dialog , which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") {dialog, which ->
                    Toast.makeText(this@MainActivity, "Game Over!", Toast.LENGTH_LONG).show()
                }
                alert.show()
                binding.lastScoreText.text = "Last Score: "+lastScore
                binding.highScoreText.text = "High Score: "+highScore
            }

        }.start()
    }


    fun hideImages()
    {
        runnable = object : Runnable
        {
            override fun run() {
                for (i in imageArray)
                {
                    i.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable, 500)
            }

        }
        handler.post(runnable)
    }

    fun increaseScore(view : View)
    {
        score += 1
        binding.scoreText.text = "Score: "+score
        sharedPreferences.edit().putInt("lastScore", score).apply()
        if(lastScore!! > highScore)
            sharedPreferences.edit().putInt("highScore", lastScore!!).apply()
    }

    fun restart(view : View)
    {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Game will restart")
        alert.setMessage("Are You Sure?")
        alert.setPositiveButton("Yes") { dialog, which ->

            val intent = intent
            finish()
            startActivity(intent)
        }
        alert.setNegativeButton("No") { dialog, which ->

            Toast.makeText(this@MainActivity, "Cancel", Toast.LENGTH_LONG).show()
        }
        alert.show()
        binding.lastScoreText.text = "Score: "+lastScore
        binding.highScoreText.text = "High Score: "+highScore
    }

    fun quitApp(view : View)
    {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Exiting app")
        alert.setMessage("Are You Sure?")
        alert.setPositiveButton("Yes") { dialog, which ->
            finishAffinity()
        }
        alert.setNegativeButton("No") {dialog, which ->
            Toast.makeText(this@MainActivity, "Canceled!", Toast.LENGTH_LONG).show()
        }
        alert.show()
    }


}
