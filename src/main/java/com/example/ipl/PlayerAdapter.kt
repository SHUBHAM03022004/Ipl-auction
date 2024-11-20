package com.example.ipl

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private val players: List<Players>) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerNameTextView: TextView = itemView.findViewById(R.id.tvPlayerName)
        val playerRoleTextView: TextView = itemView.findViewById(R.id.tvPlayerRole)
        val playerAgeTextView: TextView = itemView.findViewById(R.id.tvPlayerAge)
        val playerPriceTextView: TextView = itemView.findViewById(R.id.tvPlayerPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        Log.d("Adapter_DEBUG", "Binding player: ${player.playerName}")
        holder.playerNameTextView.text = player.playerName
        holder.playerRoleTextView.text = player.role
        holder.playerAgeTextView.text = "Age: ${player.age}"
        holder.playerPriceTextView.text = "Price: ₹${player.price}"
    }



    override fun getItemCount(): Int {
        return players.size
    }
}
