package com.dating.mdate.services

import android.annotation.SuppressLint
import android.sdei.com.basicapp.utill.DEVICE_TOKEN
import android.support.v4.app.NotificationCompat
import android.util.Log

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.support.v4.app.NotificationManagerCompat
import com.dating.mdate.R
import com.dating.mdate.utill.PreferenceConnector

class NotificationService : FirebaseMessagingService() {
    val TAG = "Service"

    override fun onNewToken(s: String?) {
        super.onNewToken(s)
        Log.e("NEW_TOKEN", s)
        PreferenceConnector.writeString(this, DEVICE_TOKEN, s!!)
    }

    @SuppressLint("LogNotTimber")
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        // Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        Log.d(TAG, "From: " + remoteMessage!!.from)
        Log.d(TAG, "Notification Message Body: " + remoteMessage.notification!!.body!!)
//        var title = remoteMessage.data[] title”);
//        var body = remoteMessage.data.get(“body”);
//        var objectId = remoteMessage.data.get(object_id);
//        var objectType = remoteMessage.getData().get(objectType”);

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            remoteMessage.notification?.let {
                Log.d(TAG, "Message Notification Body: ${it.body}")

                val mBuilder = NotificationCompat.Builder(this, R.string.default_notification_channel_id.toString())
                    .setSmallIcon(R.drawable.notification_bg)
                    .setContentTitle(it.title)
                    .setContentText(it.body)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                with(NotificationManagerCompat.from(this)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(1234, mBuilder.build())
                }
            }
        }
    }


}
