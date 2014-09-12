package com.example.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ggg.sasv2.SmartAdServer;

public class StreamActivity extends Activity {

	private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SmartAdServer.getInstance().onCreate(this);
    }


    @Override
    protected void onStop() {
    	SmartAdServer.getInstance().onStop();
    	super.onStop();
    }

    @Override
    protected void onDestroy() {
    	SmartAdServer.getInstance().onDestroy();
    	super.onDestroy();
    }
}
