package com.example.smsLogger // Assure-toi que c'est bien ton package

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.provider.Telephony
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (sms in messages) {
                val messageBody = sms.messageBody
                val address = sms.originatingAddress
                val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

                val logEntry = "[$timestamp] De: $address \nMessage: $messageBody\n---\n"
                saveToFile(context, logEntry)
            }
        }
    }

    private fun saveToFile(context: Context, content: String) {
        val fileName = "sms_backup.txt"
        
        // Option A: Dossier interne (Plus simple pour les permissions)
        val file = File(context.getExternalFilesDir(null), fileName)
        
        // Option B (Si tu préfères Documents, décommente la ligne ci-dessous)
        // val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileName)

        try {
            FileOutputStream(file, true).use { output ->
                output.write(content.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}