package tw.edu.pu.csim.tcyang.crazyshape

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
class MyAppGlideModule : AppGlideModule()

var Flag:Int=0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shape()

        Toast.makeText(baseContext, "作者：黃裕洳", Toast.LENGTH_LONG).show()

        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(imgTitle)

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java).apply {
                    putExtra("shapes",Flag) }
                //startActivity(intent)
                startActivityForResult(intent, 11)
                return true
            }
        })
        imgNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                shape()
            }
        })
    }
    fun shape() {
        Flag = (1..4).random()
        when (Flag) {
            1 -> imgNext.setImageResource(R.drawable.circle)
            2 -> imgNext.setImageResource(R.drawable.square)
            3 -> imgNext.setImageResource(R.drawable.star)
            4 -> imgNext.setImageResource(R.drawable.triangle)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 11){
            intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}