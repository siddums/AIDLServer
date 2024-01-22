package com.sd_xcod.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

/**
 * @Author: Siddu M S
 * @Email: siddushikkerimath@gmail.com
 * @Date: 21-01-2024
 */
public class AIDLColorService extends Service {

    private static String TAG = "AIDLCOlorService";

    public AIDLColorService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IAIDLColorInteface.Stub binder = new IAIDLColorInteface.Stub() {
        @Override
        public int getColor() throws RemoteException {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            Log.d(TAG, " Generating new color " + color);
            return color;
        }
    };
}
