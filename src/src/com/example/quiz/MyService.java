package com.example.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service{
	MediaPlayer mp;
	public int onStartCommand(Intent intent, int flags, int startId) {
		mp.start();
		return START_STICKY;
	}
	public void onCreate() {
		mp=MediaPlayer.create(this,R.raw.gameshow);
		mp.setLooping(true);
		super.onCreate();		
	}
	public void onDestroy() {
		mp.stop();
		mp.release();
		super.onDestroy();
	}
	public IBinder onBind(Intent arg0) {
		return null;
	}
}
