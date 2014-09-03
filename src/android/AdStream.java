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

import com.ggg.sasv2.SmartAdServer


/**
 * This class echoes a string called from JavaScript.
 */
public class AdStream extends CordovaPlugin{



    public SonataAdView adView;
    protected LinearLayout root;// original Cordova layout
    protected CordovaInterface interfaz;
    protected CordovaWebView vista;
    public SonataAdListener listener;
    private static final String LOG_TAG = "SonataPlugin";


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        interfaz = cordova;
        vista = webView;
        SASV2Configurations.enableDebugMode();
        SASV2Configurations.USE_SAS_ID_EXAMPLE=true;

        //this.cordova.getActivity().setContentView(cordova.getActivity());
        Log.i(LOG_TAG,"initialize de AdStream");

    }

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
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
        if (action.equals("create")) {
        	Log.i(LOG_TAG,"create de Sonata");
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
    	if(adView!=null){
		    adView.show();
    	}
    }

}

