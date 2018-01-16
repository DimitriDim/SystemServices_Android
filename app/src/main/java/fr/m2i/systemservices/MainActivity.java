package fr.m2i.systemservices;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.GET_ACCOUNTS}, 1);
    }

    public void testWifi(View v) {
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (wm.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            Toast.makeText(this, "Wifi dispo", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Wifi Ko ou en cours d'activation", Toast.LENGTH_LONG).show();
        }

    }

    public void volumePlus(View v) {
        AudioManager am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        am.adjustVolume(AudioManager.ADJUST_RAISE, 0);
    }

    public void volumeMoins(View v) {
        AudioManager am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        am.adjustVolume(AudioManager.ADJUST_LOWER, 0);
    }

    public void infoProprio(View v) {
        AccountManager am = (AccountManager) getApplicationContext().getSystemService(Context.ACCOUNT_SERVICE);
        //création du tab de proprio
        Account tabComtes[] = am.getAccounts();

        //recuperer le premier nom de proprio
        Account compte = tabComtes[0];
        Toast.makeText(this, "Pas de compte", Toast.LENGTH_LONG).show();
    }


}
