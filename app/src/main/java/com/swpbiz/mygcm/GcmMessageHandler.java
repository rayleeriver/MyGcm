package com.swpbiz.mygcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GcmMessageHandler extends IntentService{

    private static final int MESSAGE_NOTIFICATION_ID = 33445;

    public GcmMessageHandler() {
        super("GcmMessageHandler");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String messageType = gcm.getMessageType(intent);
        String title = extras.getString("title");
        String body = extras.getString("body");
        createNotification(title, body);
        Log.i("GCM", "Received : ( " + messageType + ") " + title);
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void createNotification(String title, String body) {
        Context context = getBaseContext();
        Intent myIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                myIntent,
                Intent.FILL_IN_ACTION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify((MESSAGE_NOTIFICATION_ID), builder.build());
    }
}
