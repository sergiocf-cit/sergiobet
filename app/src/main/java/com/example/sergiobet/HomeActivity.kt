package com.example.sergiobet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.sergiobet.adapter.FragmentAdapter
import com.example.sergiobet.adapter.NextMatchAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<ViewPager2>(R.id.viewPager2).adapter = FragmentAdapter(this)
    }
}
