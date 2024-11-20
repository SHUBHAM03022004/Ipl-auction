package com.example.ipl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamsAdapter(private val teams: List<Team>, private val onClick: (Team) -> Unit) :
    RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.teamName.text = team.name
        holder.teamOwner.text = team.owner
        holder.teamColor.setBackgroundColor(android.graphics.Color.parseColor(team.teamColor))
        holder.itemView.setOnClickListener {
            onClick(team)
        }
    }

    override fun getItemCount(): Int = teams.size

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamName: TextView = itemView.findViewById(R.id.teamName)
        val teamOwner: TextView = itemView.findViewById(R.id.teamOwner)
        val teamColor: View = itemView.findViewById(R.id.teamColor)
    }
}
