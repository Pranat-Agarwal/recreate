package com.example.recreate.kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.telephony.SmsManager
import android.util.Log

class SmsService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val phoneNumber = intent?.getStringExtra("phoneNumber")
        val message = intent?.getStringExtra("message")

        if (phoneNumber != null && message != null) {
            sendSms(phoneNumber, message)
        }

        return START_NOT_STICKY
    }

    private fun sendSms(phoneNumber: String, message: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            Log.d("SmsService", "SMS sent to $phoneNumber")
        } catch (e: Exception) {
            Log.e("SmsService", "Failed to send SMS", e)
        }
    }
}
