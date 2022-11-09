package com.gorkemozcan.artbookfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gorkemozcan.artbookfragment.model.Art
import com.gorkemozcan.artbookfragment.view.Artlist
import androidx.navigation.Navigation
import com.gorkemozcan.artbookfragment.databinding.ItemRowBinding
import com.gorkemozcan.artbookfragment.view.ArtlistDirections


class ArtListAdapter (val artList: List<Art>) : RecyclerView.Adapter<ArtListAdapter.ArtHolder>() {
    class ArtHolder (val binding : ItemRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ArtHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.artNameText.text = artList.get(position).artName
        holder.itemView.setOnClickListener {
            val action = ArtlistDirections.actionArtlistToDetailFragment("old", artList[position].id)
            Navigation.findNavController(it).navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return artList.size
    }


}