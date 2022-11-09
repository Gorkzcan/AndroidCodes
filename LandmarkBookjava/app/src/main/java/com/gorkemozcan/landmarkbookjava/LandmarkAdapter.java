package com.gorkemozcan.landmarkbookjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gorkemozcan.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    //xml bağlama işi burada yapılacak
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int position) {    //nelerin olacağını belirttiğimiz kısım aksiyon kısmıdır.

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                //intent.putExtra("landmark", landmarkArrayList.get(holder.getAdapterPosition()));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                singleton.getSentLandmark();

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }
    //kaç eleman olduğunu döndürecek
    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }
    //görünümleri tutacak olan sınıftır. Kendimiz oluşturduk.
    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        //adapter layout ile buradaki kodları birbirine bağlamak için yazıyoruz
    }


}
