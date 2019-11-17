package robocall.com.robocall.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class TermsAndCondition extends RootActivity{

    private Context mContext;
    private TextView tv_next, tv_robocall, tv_text_one, tv_terms_privacy, tv_terms, tv_privacy, tv_click_next;
    private RelativeLayout r_layout_next;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms_condition_activity);
        mContext = this;

        tv_next = (TextView)findViewById(R.id.tv_next);
        tv_robocall = (TextView)findViewById(R.id.tv_robocall);
        tv_text_one = (TextView)findViewById(R.id.tv_text_one);
        tv_terms_privacy = (TextView)findViewById(R.id.tv_terms_privacy);
        tv_terms = (TextView)findViewById(R.id.tv_terms);
        tv_privacy = (TextView)findViewById(R.id.tv_privacy);
        tv_click_next = (TextView)findViewById(R.id.tv_click_next);
        r_layout_next = (RelativeLayout) findViewById(R.id.r_layout_next);

        tv_robocall.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Regular.otf"));
        tv_text_one.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Medium.otf"));
        tv_terms_privacy.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Bold.otf"));
        tv_terms.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Medium.otf"));
        tv_privacy.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Medium.otf"));
        tv_click_next.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Medium.otf"));
        tv_next.setTypeface(Fonts.getTypefaceTwo(TermsAndCondition.this, "SF-Pro-Display-Bold.otf"));

        r_layout_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(mContext,AppPermissionActivity.class);
               startActivity(intent);
               finish();
            }
        });


    }

    @Override
    public void onBackPressed()

    {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1){
            boolean done = getSupportFragmentManager().popBackStackImmediate();
        }else
        {
            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                ActivityCompat.finishAffinity(this);
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }

    }
}
