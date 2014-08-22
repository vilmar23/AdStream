package com.example.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.LinearLayout;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ggg.sasv2.SmartAdServer;


/**
 * This class echoes a string called from JavaScript.
 */
public class AdStream extends CordovaPlugin{



    protected LinearLayout root;// original Cordova layout
    protected CordovaInterface interfaz;
    protected CordovaWebView vista;
    private static final String LOG_TAG = "SonataPlugin";


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        //super.initialize(cordova, webView);

        SASV2Configurations.enableDebugMode();
        SASV2Configurations.USE_SAS_ID_EXAMPLE=true;
        Log.i(LOG_TAG,"initialize de AdStream");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      SmartAdServer.getInstance().onCreate(MainActivity.this);
    }



    @Override
    protected void onStop() {
        super.onStop();
        SmartAdServer.getInstance().onStop();
    }

    @Override
    public void onBackPressed() {
        if(SmartAdServer.getInstance().onBackPressed()==false){
            super.onBackPressed();
        } else
            return;
     }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
      SmartAdServer.getInstance().onKeyUp(keyCode, event);
      return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
        if (action.equals("create")) {
        	Log.i(LOG_TAG,"create de AdStream");
        	creaAnuncio();
        }else if(action.equals("muestra")){
        	Log.i(LOG_TAG,"muestra anuncio");
        	muestraAnuncio();
        }
        return false;
    }

    private void creaAnuncio(){

    	cordova.getActivity().runOnUiThread(new Runnable() {

        	@Override
            public void run() {
		        // Crea el SonataAdView
		        adView = new SonataAdView(interfaz.getActivity());

		        adView.setSection("EsRadio Home");

		        //es �android:id=�@+id/layout_id�
		        root = (LinearLayout) vista.getParent();

		        //A�ade la vista al layout
		        root.addView(adView,0);

		        //Inicia el proceso para mostrar ads
		        adView.show();
        	}
        });

    }

    private void muestraAnuncio(){
    	SmartAdServer.getInstance().onCreate(MainActivity.this);
    }

}