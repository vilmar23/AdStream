package com.example.sampleapp;

import android.app.Application;

import com.ggg.sasv2.SASV2Configurations;

public class MainApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		SASV2Configurations.enableDebugMode();

	/*SASV2Configurations.ID_SITE=54391;
		SASV2Configurations.ID_BANNER=19065;
		SASV2Configurations.ID_INTERSTICIAL=19066;
		SASV2Configurations.ID_VIDEOBANNNER=19298;   */
        SASV2Configurations.USE_SAS_ID_EXAMPLE=true;
	}
}