package robocall.com.robocall.Activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class NavigationDrawer extends RootActivity {

    private Context mContext;
    private TextView tv_name, tv_sign_out, tv_phone, tv_option, tv_call, tv_call_detail, tv_contact,
                    tv_contact_detail, tv_setting, tv_setting_detail, tv_rating, tv_rating_detail,
                    tv_privacy_policy, tv_privacy_policy_detail, tv_notification, tv_notification_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        mContext = this;

        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_sign_out = (TextView)findViewById(R.id.tv_sign_out);
        tv_phone = (TextView)findViewById(R.id.tv_phone);
        tv_option = (TextView)findViewById(R.id.tv_option);
        tv_call = (TextView)findViewById(R.id.tv_call);
        tv_call_detail = (TextView)findViewById(R.id.tv_call_detail);
        tv_contact = (TextView)findViewById(R.id.tv_contact);
        tv_contact_detail = (TextView)findViewById(R.id.tv_contact_detail);
        tv_setting = (TextView)findViewById(R.id.tv_setting);
        tv_setting_detail = (TextView)findViewById(R.id.tv_setting_detail);
        tv_rating = (TextView)findViewById(R.id.tv_rating);
        tv_rating_detail = (TextView)findViewById(R.id.tv_rating_detail);
        tv_privacy_policy = (TextView)findViewById(R.id.tv_privacy_policy);
        tv_privacy_policy_detail = (TextView)findViewById(R.id.tv_privacy_policy_detail);
        tv_notification = (TextView)findViewById(R.id.tv_notification);
        tv_notification_detail = (TextView)findViewById(R.id.tv_notification_detail);

        tv_name.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_sign_out.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_option.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_call.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_call_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
        tv_contact.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_contact_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
        tv_setting.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_setting_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
        tv_rating.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_rating_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
        tv_privacy_policy.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_privacy_policy_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
        tv_notification.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Regular.otf"));
        tv_notification_detail.setTypeface(Fonts.getTypefaceTwo(NavigationDrawer.this, "SF-Pro-Display-Medium.otf"));
    }
}
