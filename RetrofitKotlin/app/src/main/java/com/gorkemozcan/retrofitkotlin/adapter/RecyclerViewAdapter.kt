package com.gorkemozcan.retrofitkotlin.adapter

import android.graphics.Color
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gorkemozcan.retrofitkotlin.R
import com.gorkemozcan.retrofitkotlin.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener: Listener ) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }
    private val colors : Array<String> = arrayOf("#008000", "#0000FF", "#800080", "#FFFF00", "#f6b26b", "#76a5af", "#000000", "#ff00ff")

    class RowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cryptoModel: CryptoModel, colors : Array<String>, position: Int, listener : Listener){

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8])) //dizi bittikten sonra çökmemesini sağlayacak yani sürekli başa dönecek
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        //hangi item ne verisi gösterecek
        holder.bind(cryptoList[position], colors, position, listener)



    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}