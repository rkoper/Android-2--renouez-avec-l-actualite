package com.m.sofiane.mynews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m.sofiane.mynews.Activity.SubActivity;
import com.m.sofiane.mynews.Modele.ModeleBase.News;

import java.util.List;


/**
 * created by Sofiane M. 06/08/2019
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<News.Articles> results;
    private Context context;

    public DataAdapter(List<News.Articles> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row ,parent, false);
        final ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, final int position) {
        News.Articles current = results.get(position);
        holder.CR_date.setText(current.getPublishedDate());
        holder.CR_category.setText(current.getSection());
        holder.CR_title.setText(current.getTitle());

        if (!current.getMultimedia().isEmpty())
        Glide.with(context).load(current.getMultimedia().get(0).getUrl()).into(holder.CR_multimedia);

        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(context, SubActivity.class);
                  intent.putExtra("url", results.get(position).getUrl());

                    context.startActivity(intent);
                }

        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView CR_date,CR_title, CR_category;
        private ImageView CR_multimedia;
        private LinearLayout item_contact;

        public ViewHolder (View itemview) {
            super (itemview);
            item_contact = (LinearLayout) itemview.findViewById(R.id.contact_item_id) ;
            CR_date = (TextView) itemview.findViewById(R.id.CR_date);
            CR_title = (TextView) itemview.findViewById(R.id.CR_title);
            CR_category= (TextView) itemview.findViewById(R.id.CR_category);
            CR_multimedia = (ImageView) itemview.findViewById(R.id.imageURL);
        }
    }
}