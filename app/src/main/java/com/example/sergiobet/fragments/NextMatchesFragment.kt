package com.example.sergiobet.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sergiobet.R
import com.example.sergiobet.adapter.NextMatchAdapter
import com.example.sergiobet.model.Match

/**
 * A simple [Fragment] subclass.
 * Use the [NextMatchesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NextMatchesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_next_matches, container, false)

        val dataset =  this.getNextMatches()

        viewManager = LinearLayoutManager(activity)
        viewAdapter = NextMatchAdapter(dataset)

        recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = NextMatchesFragment()
    }

    private fun getNextMatches(): List<Match> {
        return listOf(
            Match("Botafogo vs Cruzeiro",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png",
                "11:00 18/04/2020"),
            Match("Botafogo vs Cruzeiro",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png",
                "11:00 19/04/2020"),
            Match("Botafogo vs Atlético",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png",
                "12:00 20/04/2020"),
            Match("Atlético vs Cruzeiro",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png",
                "14:00 23/04/2020"),
            Match("Cruzeiro vs Botafogo",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png",
                "11:00 25/04/2020"),
            Match("Atlético vs Botafogo",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png",
                "https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png",
                "17:00 30/04/2020")
            )
    }
}
