package com.m.sofiane.mynews;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m.sofiane.mynews.activity.SubActivity;
import com.m.sofiane.mynews.modele.ModeleBase.News;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * created by Sofiane M.
 */
public class DataAdapterMost extends RecyclerView.Adapter<DataAdapterMost.ViewHolder> {

    private final List<News.Articles> results;
    private final Context context;


    public DataAdapterMost(List<News.Articles> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull DataAdapterMost.ViewHolder holder, final int position) {

        dateCalling(holder,position);

        titleCalling(holder, position);

        imageCalling (holder, position);


    }

    private void imageCalling(ViewHolder holder, final int position) {
        News.Articles current = results.get(position);
        if (!current.getMedia().isEmpty())
            Glide.with(context).load(current.getMedia().get(0).getMediaMetadata().get(0).getUrl()).into(holder.CR_multimedia);
        else {
            Glide.with(context).load(R.drawable.logonyta).into(holder.CR_multimedia);
        }


        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SubActivity.class);
                intent.putExtra("url", results.get(position).getUrl());

                context.startActivity(intent);
            }

        });
    }

    private void titleCalling(ViewHolder holder, int position) {
        News.Articles current = results.get(position);

        String section = current.getSection();
        String sub = current.getSubsection();

        if (TextUtils.isEmpty(sub)) {
            sub = "   ";
        } else {
            sub = " > " + sub;
        }

        String sectionSub = section + sub;
        holder.CR_category.setText(sectionSub);
        holder.CR_title.setText(current.getTitle());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void dateCalling(ViewHolder holder, int position) {
        News.Articles current = results.get(position);
        holder.CR_date.setText(DateUtils.parseMostPopularDate(current.getPublishedDate()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView CR_date;
        private final TextView CR_title;
        private final TextView CR_category;
        private final ImageView CR_multimedia;
        private final ConstraintLayout item_contact;


        ViewHolder(View itemview) {
            super(itemview);
            item_contact = itemview.findViewById(R.id.contact_item_id);
            CR_date = itemview.findViewById(R.id.CR_date);
            CR_title = itemview.findViewById(R.id.CR_title);
            CR_category = itemview.findViewById(R.id.CR_category);
            CR_multimedia = itemview.findViewById(R.id.imageURL);
        }

    }
}