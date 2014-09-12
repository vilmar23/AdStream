package com.example.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ggg.sasv2.SmartAdServer;

public class StreamActivity extends Activity {

	private Intent intent = null;

    @Override
    protected void onCreate() {


        SmartAdServer.getInstance().onCreate(StreamActivity.this);
    }


    @Override
    protected void onStop() {
    	SmartAdServer.getInstance().onStop();

    }

    @Override
    protected void onDestroy() {
    	SmartAdServer.getInstance().onDestroy();

    }
}
