package com.customautosys.saf_mediastore;

import android.content.Intent;
import android.provider.DocumentsContract;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class SafMediastore extends CordovaPlugin{
	protected HashMap<String,CallbackContext> callbacks=new HashMap<>();
	protected CordovaInterface cordovaInterface;
	protected CordovaWebView cordovaWebView;

	public enum Action {
		selectFolder,
		selectFile,
		openFolder,
		openFile,
		readFile,
		writeFile,
		saveFile,
	}

	@Override
	public void initialize(CordovaInterface cordovaInterface,CordovaWebView webView){
		this.cordovaInterface=cordovaInterface;
		this.cordovaWebView=cordovaWebView;
	}

	@Override
	public boolean execute(String action,JSONArray args,CallbackContext callbackContext)throws JSONException{
		Method method=null;
		try{
			method=this.getClass().getMethod(action,JSONArray.class,CallbackContext.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(method==null||!Modifier.isPublic(method.getModifiers()))return false;
		try{
			return (Boolean)method.invoke(this,args,callbackContext);
		}catch(Exception e){
			return false;
		}
	}

	public boolean selectFolder(JSONArray args,CallbackContext callbackContext)throws JSONException{
		String initialFolder=null;
		try{
			initialFolder=args.getString(0);
		}catch(JSONException e){
			e.printStackTrace();
		}
		Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
		if(initialFolder!=null)intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI,initialFolder);
		intent.putExtra("SafMediastore.getCallbackId",callbackContext.getCallbackId());
		callbacks.put(callbackContext.getCallbackId(),callbackContext);
		cordovaInterface.startActivityForResult(this,intent,Action.selectFolder.ordinal());
		return true;
	}

	public boolean selectFile(JSONArray args,CallbackContext callbackContext)throws JSONException{
		return true;
	}

	public boolean openFolder(JSONArray args,CallbackContext callbackContext){
		return true;
	}

	public boolean openFile(JSONArray args,CallbackContext callbackContext){
		return true;
	}

	public boolean readFile(JSONArray args,CallbackContext callbackContext){
		return true;
	}

	public boolean writeFile(JSONArray args,CallbackContext callbackContext){
		return true;
	}

	public boolean saveFile(JSONArray args,CallbackContext callbackContext){
		return true;
	}

	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data){
	}
}

