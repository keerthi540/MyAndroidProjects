package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    PendingIntent pi;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createMyNotificationChannel();
        pi= PendingIntent.getActivity (this ,RequestCode 23,i,
                PendingIntent.FLAG_UPDATE_CURRENT


    }

    private void createMyNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel nc=new NotificationChannel("MYID","MYCHANNEL",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);

        }
    }

    public void showNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MYID");
        builder.setContentTitle("MYNOTIFICATION");
        builder.setContentText("this is the first notification");
        builder.setSmallIcon(R.drawable.ic_notifications_active_black_24dp);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_ALL);
        NotificationCompat.Builder builder1 = builder.addAction(R.drawable.ic_reply_black_24dp);
        nm.notify(1,builder.build());

    }

    private Object setDefault(int defaultAll) {
    }
}

