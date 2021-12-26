package tns.fit.bstu.lab14


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fade_in.setOnClickListener {
            imageView.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            imageView.startAnimation(animationFadeIn)
        }
        fade_out.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            imageView.startAnimation(animationFadeOut)
            Handler().postDelayed({
                imageView.visibility = View.GONE
            }, 1000)
        }
        zoom_in.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            imageView.startAnimation(animationZoomIn)
        }
        zoom_out.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            imageView.startAnimation(animationZoomOut)
        }
        slide_down.setOnClickListener {
            val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_in)
            imageView.startAnimation(animationSlideDown)
        }
        slide_up.setOnClickListener {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_out)
            imageView.startAnimation(animationSlideUp)
        }
        bounce.setOnClickListener {
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            imageView.startAnimation(animationBounce)
        }
        rotate.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            imageView.startAnimation(animationRotate)
        }
    }
}