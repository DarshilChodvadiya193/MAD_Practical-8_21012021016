package com.example.mad_practical_8_21012021016

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class Alarm : BroadcastReceiver() {
companion object{
    val Alarmkey ="key"
    val AlarmStart="start"
    val AlarmStop="stop"
}
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data = intent.getStringExtra(Alarmkey)
        val intentservice = Intent(context,ALarmservice::class.java)
        if(data== AlarmStart){
            context.startService(intentservice)
        }
        else{
            context.stopService(intentservice)
        }
    }
}