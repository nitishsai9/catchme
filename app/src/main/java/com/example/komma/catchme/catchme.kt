package com.example.komma.catchme

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_catchme.*
import java.util.*

class catchme : AppCompatActivity() {
 var score : Int=0
    var imageArray =ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catchme)
        score=0
        imageArray = arrayListOf(imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8)
        hideImages()

        object : CountDownTimer(20000,1000){

            override fun onTick(p0: Long) {
                timer.text="Time"+(p0/1000)
            }
            override fun onFinish() {
                timer.text="Time 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }

            }

        }.start()


    }
    fun hideImages()
    {
        runnable = object : Runnable{
            override fun run() {

                for (image in imageArray) {

                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val index = random.nextInt(8-0)
                imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable, 400)
            }
        }
        handler.post(runnable)
    }
    fun counter(View: View)
    {
        score++
        total.text="Score:"+score

    }
}


