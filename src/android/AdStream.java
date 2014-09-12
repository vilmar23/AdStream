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

import android.view.KeyEvent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ggg.sasv2.SASV2Configurations;
import com.ggg.sasv2.SmartAdServer;


/**
 * This class echoes a string called from JavaScript.
 */
public class Adstream extends CordovaPlugin{



    //public SonataAdView adView;
    protected LinearLayout root;// original Cordova layout
    protected CordovaInterface interfaz;
    protected CordovaWebView vista;
   // public SonataAdListener listener;
    private static final String LOG_TAG = "SonataPlugin";


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        interfaz = cordova;
        vista = webView;
        SASV2Configurations.enableDebugMode();

    	/*SASV2Configurations.ID_SITE=54391;
    		SASV2Configurations.ID_BANNER=19065;
    		SASV2Configurations.ID_INTERSTICIAL=19066;
    		SASV2Configurations.ID_VIDEOBANNNER=19298;   */
        SASV2Configurations.USE_SAS_ID_EXAMPLE=true;

        //this.cordova.getActivity().setContentView(cordova.getActivity());
        Log.i(LOG_TAG,"initialize de AdStream");

    }



    public void onStop() {
           SmartAdServer.getInstance().onStop();
      }


     public void onBackPressed() {

	      if(SmartAdServer.getInstance().onBackPressed()==false){
	              //super.onBackPressed();
	      } else
              return;

     }


     public void onKeyUp(int keyCode, KeyEvent event) {

    	SmartAdServer.getInstance().onKeyUp(keyCode, event);

    	//return super.onKeyUp(keyCode, event);
     }

    /*
    @Override
    public void onStart(SonataAdView adView){
    	Log.i(LOG_TAG,"Empieza un anuncio");
    }

    @Override
    public void onAdShown(SonataAdView adView){
    	Log.i(LOG_TAG,"Se muetsra el anuncio");
    }

    @Override
    public void onAdClosed(SonataAdView adView, String motive){
    	Log.i(LOG_TAG,"Se cierra el anuncio por"+motive);
    }

    @Override
    public void onNotAdReceived(SonataAdView adView){
    	Log.i(LOG_TAG,"No se recibio el anuncio");
    }

    @Override
    public void onError(SonataAdView adView, String error){
    	Log.i(LOG_TAG,"Error de sonata por: "+error);
    }

    @Override
    public void onPause(boolean multitasking) {
       super.onPause(multitasking);
        if (adView != null ) adView.hide();
    }*/

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
		        /*adView = new SonataAdView(interfaz.getActivity());

		        adView.setSection("EsRadio Home");

		        //es “android:id=”@+id/layout_id”
		        root = (LinearLayout) vista.getParent();

		        //Añade la vista al layout
		        root.addView(adView,0);

		        //Inicia el proceso para mostrar ads
		        adView.show();*/
        		SmartAdServer.getInstance().onCreate(interfaz.getActivity());
        	}
        });

    }

    private void muestraAnuncio(){
    	cordova.getActivity().runOnUiThread(new Runnable() {

        	@Override
            public void run() {
		        // Crea el SonataAdView
		        /*adView = new SonataAdView(interfaz.getActivity());

		        adView.setSection("EsRadio Home");

		        //es “android:id=”@+id/layout_id”
		        root = (LinearLayout) vista.getParent();

		        //Añade la vista al layout
		        root.addView(adView,0);

		        //Inicia el proceso para mostrar ads
		        adView.show();*/
        		SmartAdServer.getInstance().onCreate(interfaz.getActivity());
        	}
        });
    	/*if(adView!=null){
		    adView.show();
    	}*/
    }

}