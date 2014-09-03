package com.example.sampleapp;

import android.app.Application;

import com.ggg.sasv2.SASV2Configurations;
import android.util.Log;

public class MainApp extends Application {

    private static final String LOG_TAG = "AdStreamPlugin";

	@Override
	public void onCreate() {
		super.onCreate();

		SASV2Configurations.enableDebugMode();

	/*SASV2Configurations.ID_SITE=54391;
		SASV2Configurations.ID_BANNER=19065;
		SASV2Configurations.ID_INTERSTICIAL=19066;
		SASV2Configurations.ID_VIDEOBANNNER=19298;   */
        SASV2Configurations.USE_SAS_ID_EXAMPLE=true;
        Log.i(LOG_TAG,"Main App");
	}
}