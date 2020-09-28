package com.lotifurrahman.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    Context context;
    ArrayList<MainList> title;

    public MainAdapter(Context context, ArrayList<MainList> title) {
        this.context = context;
        this.title = title;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.main_list_sample, parent, false);

        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        MainList surahListOnly = title.get(position);
        holder.textViewtitle.setText(surahListOnly.getSurah_name());
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView textViewtitle, textViewDescr;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewtitle = itemView.findViewById(R.id.Custom_TextView_SurahName_Id);
            textViewDescr = itemView.findViewById(R.id.Custom_TextView_DescendClass_Id);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

}
