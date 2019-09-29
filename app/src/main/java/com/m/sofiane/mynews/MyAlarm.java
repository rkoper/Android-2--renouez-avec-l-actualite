package com.m.sofiane.mynews;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.m.sofiane.mynews.activity.MainActivity;
import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

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

    Map<String,String> researchValue = new HashMap<>();

    private int mNumArticle = 0;
    private String mArticle = "article";
    private String mArticles = "articles";
    private Context mContext;
    private String SEARCHSECTION = "section";
    private String mSection;
    protected String mQueryTerm;
    private String SEARCHWORD = "term";
    private SearchResult rvdata;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        controleArticle(context);



    }

    private void controleArticle(Context context) {
        String mSection = context.getSharedPreferences("My settings", MODE_PRIVATE).getString(SEARCHSECTION, null);
        String mQueryTerm = context.getSharedPreferences("My settings", MODE_PRIVATE).getString(SEARCHWORD, null);

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
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult jsonResponse2 = response.body();
                mNumArticle = jsonResponse2.getResponse().getDocs().size();
                createNotif();

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) { Log.d("Error", t.getMessage());
            }
        });
    }

            private void createNotif() {

        Intent intent1 = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent1, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("My News");
        if (mNumArticle==0) {
            inboxStyle.addLine("Today "+mNumArticle +" "+ mArticle + "for you");}
        else {inboxStyle.addLine("Today "+mNumArticle +" "+ mArticles + "for you");}

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