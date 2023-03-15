package com.example.todoapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


//if device gets rebooted in that case our alarm which we set previous to reboot will be cleared so in order to set it again after reboot we use this broadcast receiver
class DeviceBootReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1?.action.equals("android.intent.action.BOOT-COMPLETED")){
            //pending to work on these
        }
    }
}