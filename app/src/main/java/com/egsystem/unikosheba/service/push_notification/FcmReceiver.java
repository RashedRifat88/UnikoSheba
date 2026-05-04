//package com.egsystem.unikosheba.service.push_notification;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.os.Build;
//import android.util.Log;
//
//import androidx.core.app.NotificationCompat;
//
//import com.egsystem.unikosheba.R;
//import com.egsystem.unikosheba.SplashActivity;
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
//
//public class FcmReceiver extends FirebaseMessagingService {
//
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        // TODO(developer): Handle FCM messages here.
//        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
//        Log.d("tag_rifat", "From: " + remoteMessage.getFrom());
//
////        // Check if message contains a data payload.
////        if (remoteMessage.getData().size() > 0) {
////            Log.d("tag_rifat", "Message data payload: " + remoteMessage.getData());
////
////            if (/* Check if data needs to be processed by long running job */ true) {
////                // For long-running tasks (10 seconds or more) use WorkManager.
////                scheduleJob();
////            } else {
////                // Handle message within 10 seconds
////                handleNow();
////            }
////
////        }
//
//        // Check if message contains a notification payload.
//        if (remoteMessage.getNotification() != null) {
//            Log.d("tag_rifat", "Message Notification Body: " + remoteMessage.getNotification().getBody());
//            Log.d("tag_rifat", "Message Notification Body: " + remoteMessage.getNotification().getTitle());
//            Log.d("tag_rifat", "Message Notification image: " + remoteMessage.getNotification().getImageUrl());
//            Log.d("tag_rifat", "Message getRawData: " + remoteMessage.getRawData());
//
////            showNotification(remoteMessage.getFrom(), remoteMessage.getNotification().getBody());
//            sendNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
//        }
//
//
//    }
//
//    private void showNotification(String from, String body) {
////        Toast.makeText(this, "From: "+from + " " + "Body: "+body, Toast.LENGTH_SHORT).show();
//
////        new Handler(Looper.getMainLooper()).post(new Runnable(){
////
////            @Override
////            public void run() {
////
////            }
////        });
//
//    }
//
//    private void sendNotification(String messageBody, String messageTitle) {
//
//        NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();
//        notiStyle.setSummaryText(messageBody);
////        notiStyle.bigPicture(messageBody);
//
//
////        Intent intent = new Intent(this, NotificationActivity.class);
////        Intent intent = new Intent(getApplicationContext(), PushNotificationActivity.class);
//        Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("fcm_notification", "fcm_notification");
////        intent.putExtra("fcm_notification", "yes");
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_IMMUTABLE);
//
//
//        String channelId = "mymensingh_helpline_channel";
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder =
//                new NotificationCompat.Builder(this, channelId)
//                        .setSmallIcon(R.drawable.logo)
//                        .setContentTitle("Mymensingh Helpline")
//                        .setContentText(messageBody)
//                        .setAutoCancel(true)
//                        .setSound(defaultSoundUri)
//                        .setContentIntent(pendingIntent)
//                        .setStyle(notiStyle);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // Since android Oreo notification channel is needed.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(channelId,
//                    "mymensing helpline",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            notificationManager.createNotificationChannel(channel);
//        }
//
////        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
//        notificationManager.notify(0, notificationBuilder.build());
//    }
//
//
//}
