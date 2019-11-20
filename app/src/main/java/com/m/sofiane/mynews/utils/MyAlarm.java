package com.m.sofiane.mynews.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.m.sofiane.mynews.R;
import com.m.sofiane.mynews.controler.activity.MainActivity;
import com.m.sofiane.mynews.model.modeleSearch.SearchResult;
import com.m.sofiane.mynews.services.NYTimesService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

/**
 * created by Sofiane M. 2019-09-22
 */
public class MyAlarm  extends BroadcastReceiver {

    private final Map<String,String> researchValue = new HashMap<>();

    private int mNumArticle = 0;
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        controleArticle(context);



    }

    private void controleArticle(Context context) {

        Date mDate = new Date();
        SimpleDateFormat string = new SimpleDateFormat("yyyyMMdd");
        String mBeginDate = string.format(mDate);
        String SEARCHSECTION = "section";
        String mSection = context.getSharedPreferences("My settings", MODE_PRIVATE).getString(SEARCHSECTION, null);
        String SEARCHWORD = "term";
        String mQueryTerm = context.getSharedPreferences("My settings", MODE_PRIVATE).getString(SEARCHWORD, null);


        researchValue.put("begin_date", mBeginDate);
        researchValue.put("fq", mSection);
        researchValue.put("q", mQueryTerm);
        loadJSONResult();
    }

    private void loadJSONResult(){
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NYTimesService request = retrofit2.create(NYTimesService.class);
        Call<SearchResult> call2 = request.getJSON4(researchValue);

        call2.enqueue(new Callback<SearchResult>() {

            @Override
            public void onResponse(@NonNull Call<SearchResult> call2, @NonNull Response<SearchResult> response) {
                SearchResult jsonResponse2 = response.body();
                mNumArticle = jsonResponse2.getResponse().getDocs().size();
                createNotif();
            }

            @Override
            public void onFailure(@NonNull Call<SearchResult> call, @NonNull Throwable t) { Log.d("Error", t.getMessage());
            }
        });
    }

            private void createNotif() {

        Intent intent1 = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent1, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("My News");
        if (mNumArticle==0) {
            String article = "article";
            inboxStyle.addLine("Today "+mNumArticle +" "+ article + " for you");}
        else {
            String articles = "articles";
            inboxStyle.addLine("Today "+mNumArticle +" "+ articles + " for you");}

        String channelId = "MyID";

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(mContext, channelId)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("My News")
                        .setContentText("My News")
                        .setAutoCancel(true)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setContentIntent(pendingIntent)
                        .setStyle(inboxStyle);

        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "Message provenant de Firebase";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        notificationManager.notify("TAG", 120, notificationBuilder.build());
    }
}