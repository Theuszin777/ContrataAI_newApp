package magnago.matheus.contrata_app.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {

    public static String CONTRATAI_URL = "http://10.0.2.2/";

    public static void setEmail(Context context, String email) {
        SharedPreferences mPrefs = context.getSharedPreferences("configs", 0);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putString("email", email).apply();
    }


    public static String getEmail(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences("configs", 0);
        return mPrefs.getString("email", "");
    }


    public static void setPassword(Context context, String password) {
        SharedPreferences mPrefs = context.getSharedPreferences("configs", 0);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putString("password", password).apply();
    }


    /*public static String getPassword(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences("configs", 0);
        return mPrefs.getString("password", "");
    }*/

}
