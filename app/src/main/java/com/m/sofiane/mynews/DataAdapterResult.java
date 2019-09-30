package com.m.sofiane.mynews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private SearchResult results1;
    private Context contextSearch;
    String url;
    private String mPubDate;
    private String mSectionSub;
    private String mSection;
    private String mSub1;


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

        mSection = current.getSectionName();

        if (current.getSubsection() == null) {
            mSub1="";
          } else {mSub1 = " > " +current.getSubsection();
            }

        mSectionSub = mSection + mSub1;
        holder.CR_category.setText(mSectionSub);
        holder.CR_title.setText(current.getSnippet());



        if (current.getMultimedia().isEmpty()){
            Glide.with(contextSearch).load(R.drawable.logonyta).into(holder.CR_multimedia);
        }
        else {
            url ="https://static01.nyt.com/"+current.getMultimedia().get(position).getUrl();
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

    public int getItemCount() {
        return results1
                .getResponse()
                .getDocs()
                .size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView CR_date,CR_title, CR_category;
        private ImageView CR_multimedia;
        private ConstraintLayout item_contact;

        public ViewHolder (View itemview) {
            super (itemview);
            item_contact = (ConstraintLayout) itemview.findViewById(R.id.contact_item_id) ;
            CR_date= (TextView) itemview.findViewById(R.id.CR_date);
            CR_title = (TextView) itemview.findViewById(R.id.CR_title);
            CR_category= (TextView) itemview.findViewById(R.id.CR_category);
            CR_multimedia = (ImageView) itemview.findViewById(R.id.imageURL);
        }
    }
}
