package com.example.mad_practical_8_21012021016

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setalarm(militime:Long,action:String){
        val intentalarm=Intent(applicationContext,Alarm::class.java)
        intentalarm.putExtra(Alarm.Alarmkey,action)

        val pendingIntent= PendingIntent.getBroadcast(applicationContext,4345,intentalarm,PendingIntent.FLAG_IMMUTABLE or  PendingIntent.FLAG_UPDATE_CURRENT)
        val manager =getSystemService(ALARM_SERVICE) as AlarmManager

        if(action == Alarm.AlarmStart){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingIntent)
        }
        else if (action == Alarm.AlarmStop){
            manager.cancel(pendingIntent)
            sendBroadcast(intentalarm)
        }

    }
}