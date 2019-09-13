package com.m.sofiane.mynews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.m.sofiane.mynews.Activity.SubActivity;
import com.m.sofiane.mynews.Modele.ModeleSearch.SearchResult;

import java.util.List;

/**
 * created by Sofiane M. 2019-08-26
 */
public class DataAdapterResult extends RecyclerView.Adapter<DataAdapterResult.ViewHolder>{

    private SearchResult results1;
    private Context contextSearch;
    String url;
    private SearchResult.Doc result2;


    public DataAdapterResult (SearchResult results1, Context context) {
        this.results1 = results1;
        this.contextSearch = context;
    }
    @NonNull
    @Override
    public DataAdapterResult.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(contextSearch).inflate(R.layout.card_row ,parent, false);
        final ViewHolder vHolder = new DataAdapterResult.ViewHolder(view);



        return vHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull DataAdapterResult.ViewHolder holder, final int position) {
        SearchResult.Doc current = results1.getResponse().getDocs().get(position);
        holder.CR_date.setText(current.getPubDate());
        holder.CR_title.setText(current.getSnippet());
        holder.CR_cat.setText(current.getSectionName());



        if (!current.getMultimedia().isEmpty())
            url ="https://static01.nyt.com/"+current.getMultimedia().get(position).getUrl();
            Glide.with(contextSearch).load(url).into(holder.CR_multimedia);



        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contextSearch, SubActivity.class);
                intent.putExtra("url", results1.getResponse().getDocs().get(position).getWebUrl());

                contextSearch.startActivity(intent);
            }

        });
    }

    public int getItemCount() {
        return results1
                .getResponse()
                .getDocs()
                .size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView CR_date,CR_title, CR_cat;
        private ImageView CR_multimedia;
        private LinearLayout item_contact;

        public ViewHolder (View itemview) {
            super (itemview);
            item_contact = (LinearLayout) itemview.findViewById(R.id.contact_item_id) ;
            CR_date= (TextView) itemview.findViewById(R.id.CR_date);
            CR_title = (TextView) itemview.findViewById(R.id.CR_title);
            CR_cat= (TextView) itemview.findViewById(R.id.CR_category);
            CR_multimedia = (ImageView) itemview.findViewById(R.id.imageURL);
        }
    }
}
