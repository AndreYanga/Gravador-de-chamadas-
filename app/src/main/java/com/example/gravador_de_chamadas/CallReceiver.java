package com.example.gravador_de_chamadas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {
    private static final String TAG = "CallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
            // Chamada recebida
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.d(TAG, "Chamada recebida de: " + incomingNumber);
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
            // Chamada atendida ou efetuada
            Log.d(TAG, "Chamada atendida ou efetuada.");
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
            // Chamada finalizada
            Log.d(TAG, "Chamada finalizada.");
        }
    }
}
