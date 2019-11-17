package robocall.com.robocall.Controller;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSession {


    private static final String PREF_NAME = "pumpkin";
    private static AppSession sInstance;
    private final SharedPreferences mPref;
    public static String FIRST_TIME_LOADER = "first_time_loader";
    private String Phone_Number = "phone_number";

    public AppSession(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppSession(context);
        }
    }

    public static synchronized AppSession getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(
                    AppSession.class.getSimpleName()
                            + " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setisFirstTimeLoader(boolean firstTimeUser) {
        mPref.edit().putBoolean(FIRST_TIME_LOADER, firstTimeUser).commit();
    }



    public boolean getisFirstTimeLoader() {
        return mPref.getBoolean(FIRST_TIME_LOADER, false);
    }

    public void setPhone_Number(String phone_number) {
        mPref.edit().putString(this.Phone_Number, phone_number).commit();
    }

    public String getPhone_Number() {
        return mPref.getString(this.Phone_Number, "");
    }

}
