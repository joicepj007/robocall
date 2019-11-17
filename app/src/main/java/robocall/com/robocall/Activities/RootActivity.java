package robocall.com.robocall.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import robocall.com.robocall.Util.ConnectionDetector;

public class RootActivity extends AppCompatActivity implements DialogInterface.OnCancelListener {

    private int screenHeightInPixels = 0, screenWidhtInPixels = 0;

    private ConnectionDetector objDetector;
    private ProgressDialog progress;
    public static boolean loaderFlag=false;
   /* public static boolean rateusFlag=false;
    public static boolean pushFlag=false;
    public static boolean commitFlag=false;*/


    public RootActivity() {

        // instance = this;
        // TODO Auto-generated constructor stub
    }


    //ProgressHUD mProgressHUD;


    public void showToastMessage(final String message){
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState, int resLayout) {
        super.onCreate(savedInstanceState);
        setContentView(resLayout);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeightInPixels = displaymetrics.heightPixels;
        screenWidhtInPixels = displaymetrics.widthPixels;
        objDetector = new ConnectionDetector(getApplicationContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeightInPixels = displaymetrics.heightPixels;
        screenWidhtInPixels = displaymetrics.widthPixels;
    }

    public int getScreenHeightInPixels() {
        return screenHeightInPixels;
    }

    public int getScreenWidhtInPixels() {
        return screenWidhtInPixels;
    }


    private void progressDialog ()
    {
        progress=new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.setCancelable(false);
        // progress.setProgress(0);
        progress.show();
    }


   /* public boolean CheckInternetStatus(){

        if (!objDetector.isConnectingToInternet()) {
            showSnackBar("No Internet Connection");
            return false;
        }
        else
        {
            return true;
        }


    }*/

    public void showBusyAnimation(){
        loaderFlag=true;
        progress=new ProgressDialog(RootActivity.this);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.setCancelable(false);
        // progress.setProgress(0);
        progress.show();


    }

    public void hideBusyAnimation() {

        if(loaderFlag)
        {
            new Thread(new Runnable() {
                @Override
                public void run()
                {
                    // do the thing that takes a long time

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            progress.dismiss();
                        }
                    });
                }
            }).start();
        }




    }
    /*public void showSnackBar(String message) {
        try {
            final Snackbar snack = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
            View view = snack.getView();
            snack.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snack.dismiss();
                }
            });
            snack.setActionTextColor(getResources().getColor(R.color.colorWhite));
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(getResources().getColor(R.color.colorWhite));
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            snack.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    @Override
    public void onCancel(DialogInterface dialog) {
        // TODO Auto-generated method stub

    }



    protected void onResume() {
        super.onResume();
    }
    protected void onPause() {
        super.onPause();
    }
    protected void onDestroy() {

        //PersitentUtil.saveCommonData();
        super.onDestroy();
    }


    public void hideSoftKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSoftKeyboard(View focusView) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(focusView,
                    inputMethodManager.SHOW_FORCED);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }
}
