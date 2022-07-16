package com.customautosys.saf_mediastore;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.function.BiFunction;

public class SafMediastore extends CordovaPlugin{

	public enum Action{
		selectFolder(SafMediastore::selectFolder),
		openFolder(SafMediastore::openFolder),
		openFile(SafMediastore::openFile),
		readFile(SafMediastore::readFile),
		writeFile(SafMediastore::writeFile),
		saveFile(SafMediastore::saveFile),
		MAX_VALUE(null);
		public BiFunction<JSONArray,CallbackContext,Boolean> function;

		Action(BiFunction<JSONArray,CallbackContext,Boolean> function){
			this.function=function;
		}
	}

	protected static CallbackContext callbacks[]=new CallbackContext[Action.MAX_VALUE.ordinal()];

	@Override
	public boolean execute(String actionString,JSONArray args,CallbackContext callbackContext) throws JSONException{
		Action action=null;
		try{
			action=Action.valueOf(actionString);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(action==null||action.function==null)return false;
		return action.function.apply(args,callbackContext);
	}

	public static Boolean selectFolder(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.selectFolder.ordinal()]=callbackContext;
		return true;
	}

	public static Boolean openFolder(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.openFolder.ordinal()]=callbackContext;
		return true;
	}

	public static Boolean openFile(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.openFile.ordinal()]=callbackContext;
		return true;
	}

	public static Boolean readFile(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.readFile.ordinal()]=callbackContext;
		return true;
	}

	public static Boolean writeFile(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.writeFile.ordinal()]=callbackContext;
		return true;
	}

	public static Boolean saveFile(JSONArray args,CallbackContext callbackContext){
		callbacks[Action.saveFile.ordinal()]=callbackContext;
		return true;
	}

	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent data){
	}
}

