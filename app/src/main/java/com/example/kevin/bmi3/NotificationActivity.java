package com.example.kevin.bmi3;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String TypeNotification = bundle.getString("KEY_NOTIFICATION");
        switch (TypeNotification){
            case "new":
                System.out.println("new");
                showNewNotification(80);
                break;
            case "alarm" :
                System.out.println("alarm");
                showAlarmManager();
                break;
            default:
                System.out.println("default");
                showOldNotification(80);
        }
//
//        if (TypeNotification.equals("new")) {
//
//        }
//        else {
//
//            showOldNotification(80);
//        }

    }
    protected void showAlarmManager(){
        AlarmManager barManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent conentIntent=PendingIntent.getActivity(
                this,
                0,
                new Intent(this,MainActivity.class), //點選通知事項後,畫面可切換到MainActivity.class
                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification barMsg=new Notification.Builder(this)  //新版本建立方法
                .setContentTitle("第一次通知,您的BMI值超過")
                .setContentText("通知監護人")
                .setSmallIcon(R.drawable.pikachu)
                .setContentIntent(conentIntent)
                .build();
        barMsg.sound= Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.ios_notification);
//        barManager.notify();//這一行會出錯…
        Toast.makeText(this,"這一行會出錯barManager.notify()",Toast.LENGTH_SHORT).show();
    }
    protected void showOldNotification(double BMI){
        Toast.makeText(this,"舊方法系統已不建意使用",Toast.LENGTH_SHORT).show();
              //舊方法目前系統已不建議使用
//        Notification barMsg=new Notification(R.drawable.squirtle,"過重囉",System.currentTimeMillis());
//        barMsg.setLatestEventInfo(
//                Report.this,
//                "您的BMI值過"高,
//                "通知監護人",
//                contentIntent
//        );
    }
    protected void showNewNotification(double BMI){
        NotificationManager barManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent conentIntent=PendingIntent.getActivity(
                this,
                0,
                new Intent(this,MainActivity.class), //點選通知事項後,畫面可切換到MainActivity.class
                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification barMsg=new Notification.Builder(this)  //新版本建立方法
                .setContentTitle("第一次通知,您的BMI值超過")
                .setContentText("通知監護人")
                .setSmallIcon(R.drawable.pikachu)
                .setContentIntent(conentIntent)
                .build();
        barMsg.sound= Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.ios_notification);
        barManager.notify(0,barMsg);

        Notification barMsg1=new Notification.Builder(this)  //新版本建立方法
                .setContentTitle("第二次通知,您的BMI值超過標準")
                .setContentText("通知監護人")
                .setSmallIcon(R.drawable.pikachu)
                .setContentIntent(conentIntent)
                .build();
        barMsg1.sound= Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.ios_notification);
        barManager.notify(1,barMsg1);//第二次通知,編號為1
    }

    public void openFinish(View target){
        finish();

    }
}
