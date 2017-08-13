package app.letsqit.com.autodsl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.letsqit.com.annotations.annotations.AutoDSL

//@AutoDSL
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
