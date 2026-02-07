package com.votre.backup.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Le système a redémarré. 
            // Le SmsReceiver est automatiquement ré-enregistré par Android 
            // grâce à sa déclaration dans le Manifest.
            Log.d("SmsBackup", "Système redémarré, surveillance SMS active.")
        }
    }
}