package com.example.sergiobet.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sergiobet.fragments.ChamptionsFragment
import com.example.sergiobet.fragments.NewsFragment
import com.example.sergiobet.fragments.NextMatchesFragment

class FragmentAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewsFragment.newInstance()
            1 -> ChamptionsFragment.newInstance()
            else -> NextMatchesFragment.newInstance()
        }
    }


}