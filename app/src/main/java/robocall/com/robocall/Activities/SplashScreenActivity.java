package robocall.com.robocall.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import robocall.com.robocall.Controller.AppSession;
import robocall.com.robocall.R;

public class SplashScreenActivity extends RootActivity {
    private int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen_activity);



        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                callHome();

            }
        }, SPLASH_TIME_OUT);

    }

    private void callHome() {


        SharedPreferences settings=getSharedPreferences("prefs",0);
        boolean firstRun=settings.getBoolean("firstRun",false);
        if(firstRun==false)//if running for first time
        //Splash will load for first time
        {
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("firstRun",true);
            editor.commit();
            AppSession.getInstance().setisFirstTimeLoader(true);
            Intent intent = new Intent(this, TermsAndCondition.class);
            startActivity(intent);
            finish();
        }
        else {

            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);
            finish();
        }

       /* Intent intent = new Intent(this, TermsAndCondition.class);
        startActivity(intent);
        finish();*/
    }


    @Override
    protected void onRestart() {

        callHome();

        super.onRestart();
    }



    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();  // optional depending on your needs
    }


}
