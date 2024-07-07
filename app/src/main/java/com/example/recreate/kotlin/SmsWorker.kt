package com.example.recreate.kotlin

import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.util.Calendar
import java.util.concurrent.TimeUnit

class SmsWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        val phoneNumber = inputData.getString("phoneNumber")
        val message = inputData.getString("message")
        val intent = Intent(applicationContext, SmsService::class.java).apply {
            putExtra("phoneNumber", phoneNumber)
            putExtra("message", message)
        }
        applicationContext.startService(intent)
        return Result.success()
    }

    companion object {
        fun scheduleSms(context: Context, phoneNumber: String, message: String, delay: Long) {
            val workRequest = OneTimeWorkRequestBuilder<SmsWorker>()
                .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                .setInputData(workDataOf("phoneNumber" to phoneNumber, "message" to message))
                .build()

            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }
}
