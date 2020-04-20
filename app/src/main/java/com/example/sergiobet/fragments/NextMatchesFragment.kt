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
import com.example.sergiobet.dao.AppDatabase
import com.example.sergiobet.model.Match
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * A simple [Fragment] subclass.
 * Use the [NextMatchesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NextMatchesFragment() : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_next_matches, container, false)

        this.getNextMatches().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                viewManager = LinearLayoutManager(activity)
                viewAdapter = NextMatchAdapter(it)

                recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance() = NextMatchesFragment()
    }

    private fun getNextMatches(): Observable<List<Match>> {
        return AppDatabase.getDatabase(requireContext()).nextMatchesDao().getAllAsync()
    }
}
