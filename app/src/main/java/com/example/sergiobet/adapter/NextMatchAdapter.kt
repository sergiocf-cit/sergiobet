package com.example.sergiobet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sergiobet.R
import com.example.sergiobet.model.Match
import com.squareup.picasso.Picasso


class NextMatchAdapter(private val nextMatchData: List<Match>) :
    RecyclerView.Adapter<NextMatchAdapter.NextMatchHolder>() {

    class NextMatchHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.next_match_item, parent, false)

        return NextMatchHolder(view)
    }

    override fun getItemCount(): Int {
        return nextMatchData.size
    }

    override fun onBindViewHolder(holder: NextMatchHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.team_name).text = nextMatchData[position].description
        holder.view.findViewById<TextView>(R.id.scheduledTime).text = nextMatchData[position].scheduledTime

        Picasso.get().load(nextMatchData[position].homeTeamFlag)
            .into(holder.view.findViewById<ImageView>(R.id.homeImage))

        Picasso.get().load(nextMatchData[position].visitorTeamFlag)
            .into(holder.view.findViewById<ImageView>(R.id.visitorImage))
    }

}