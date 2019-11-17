package robocall.com.robocall.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class AppPermissionActivity extends RootActivity {

    private Context mContext;
    private TextView tv_next, tv_app_permission, tv_contact_access, tv_call_access, tv_network_access, tv_location_access;
    private RelativeLayout r_layout_next;
    private Switch switch1, switch2, switch3, switch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_permission_activity);
        mContext = this;

        tv_next = (TextView)findViewById(R.id.tv_next);
        tv_app_permission = (TextView)findViewById(R.id.tv_app_permission);
        tv_contact_access = (TextView)findViewById(R.id.tv_contact_access);
        tv_call_access = (TextView)findViewById(R.id.tv_call_access);
        tv_network_access = (TextView)findViewById(R.id.tv_network_access);
        tv_location_access = (TextView)findViewById(R.id.tv_location_access);
        r_layout_next = (RelativeLayout) findViewById(R.id.r_layout_next);
        switch1 = (Switch)findViewById(R.id.switch1);
        switch2 = (Switch)findViewById(R.id.switch2);
        switch3 = (Switch)findViewById(R.id.switch3);
        switch4 = (Switch)findViewById(R.id.switch4);

        tv_app_permission.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_contact_access.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Medium.otf"));
        tv_call_access.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Medium.otf"));
        tv_network_access.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Medium.otf"));
        tv_location_access.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Medium.otf"));
        tv_next.setTypeface(Fonts.getTypefaceTwo(AppPermissionActivity.this, "SF-Pro-Display-Bold.otf"));

        r_layout_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,PhoneNumberActivity.class);
                startActivity(intent);
                finish();

            }
        });

        if (switch4.isChecked()){

            turnGPSOn();


                //turnGPSOn();
        }

    }

    private void turnGPSOn(){
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if(!provider.contains("gps")){ //if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);
        }
    }



    @Override
    public void onBackPressed() {

        Intent i = new Intent(AppPermissionActivity.this,TermsAndCondition.class);
        // i.putExtra("to","account");
        startActivity(i);
        finish();


    }
}
