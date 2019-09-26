package com.m.sofiane.mynews;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.m.sofiane.mynews.activity.MainActivity;
import com.m.sofiane.mynews.activity.PageNotification;
import com.m.sofiane.mynews.modele.ModeleSearch.SearchResult;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * created by Sofiane M. 2019-09-22
 */
public class MyAlarm  extends BroadcastReceiver {

    private Map<String, String> researchValue = new HashMap<>();
    private String SEARCHWORD = "save term";
    private String SEARCHSECTION = "save section";
    private String SEArCHSWITCH = "save button";
    private int mNumArticle = 0;
    private String mArticle = "article";
    private String mArticles = "articles";
    private SearchResult results1;
    private Context context;
    private SearchResult rvdata;
    private Switch mSwitch;
    private TextView mText;
    public String NOTIFICATION = "notification";
    protected String mQueryTerm;
    private EditText mEditTextSearchTerm;
    protected String mSection;
    int NOTIFICATION_ID =120 ;
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        createNotif();

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