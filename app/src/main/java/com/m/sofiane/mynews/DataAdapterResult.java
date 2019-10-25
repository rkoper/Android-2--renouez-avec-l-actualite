package com.m.sofiane.mynews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.m.sofiane.mynews.activity.SubActivity;
import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by Sofiane M. 2019-08-26
 */
public class DataAdapterResult extends RecyclerView.Adapter<DataAdapterResult.ViewHolder>{

    private final SearchResult results1;
    private final Context contextSearch;
    private String mPubDate;


    public DataAdapterResult (SearchResult results1, Context context) {
        this.results1 = results1;
        this.contextSearch = context;
    }
    @NonNull
    @Override
    public DataAdapterResult.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(contextSearch).inflate(R.layout.card_row ,parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull DataAdapterResult.ViewHolder holder, final int position) {
        dateCalling(holder,position);

        titleCalling(holder, position);

        imageCalling (holder, position);
    }

    private void imageCalling(ViewHolder holder, final int position) {
        SearchResult.Doc current = results1.getResponse().getDocs().get(position);
        if (current.getMultimedia().isEmpty()){
            Glide.with(contextSearch).load(R.drawable.logonyta).into(holder.CR_multimedia);
        }
        else {
            String url = "https://static01.nyt.com/" + current.getMultimedia().get(position).getUrl();
            Glide.with(contextSearch).load(url).into(holder.CR_multimedia);}



        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contextSearch, SubActivity.class);
                intent.putExtra("url", results1.getResponse().getDocs().get(position).getWebUrl());

                contextSearch.startActivity(intent);
            }

        });
    }

    private void titleCalling(ViewHolder holder, int position) {
        SearchResult.Doc current = results1.getResponse().getDocs().get(position);
        String section = current.getSectionName();

        String sub1;
        if (current.getSubsection() == null) {
            sub1 ="";
        } else {
            sub1 = " > " +current.getSubsection();
        }

        String sectionSub = section + sub1;
        holder.CR_category.setText(sectionSub);
        holder.CR_title.setText(current.getSnippet());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void dateCalling(ViewHolder holder, int position) {
        SearchResult.Doc current = results1.getResponse().getDocs().get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat str = new SimpleDateFormat("dd/mm/yyyy");
        Date today = null;
        try {
            today = sdf.parse(current.getPubDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mPubDate = str.format(today);
        holder.CR_date.setText(mPubDate);
    }

    public int getItemCount() {
        return results1
                .getResponse()
                .getDocs()
                .size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView CR_date;
        private final TextView CR_title;
        private final TextView CR_category;
        private final ImageView CR_multimedia;
        private final ConstraintLayout item_contact;

        ViewHolder(View itemview) {
            super (itemview);
            item_contact = itemview.findViewById(R.id.contact_item_id);
            CR_date= itemview.findViewById(R.id.CR_date);
            CR_title = itemview.findViewById(R.id.CR_title);
            CR_category= itemview.findViewById(R.id.CR_category);
            CR_multimedia = itemview.findViewById(R.id.imageURL);
        }
    }
}
