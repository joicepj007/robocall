package robocall.com.robocall.Activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class PrivacyPolicyActivity extends RootActivity {

    private Context mContext;
    private ImageView back_arrow;
    private TextView tv_privacy_one, tv_privacy_two, tv_privacy_three,tv_privacy_four, tv_privacy_five,
                    tv_privacy_six, tv_privacy_seven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy_activity);
        mContext = this;

        back_arrow= (ImageView)findViewById(R.id.back_arrow);
        tv_privacy_one =(TextView)findViewById(R.id.tv_privacy_one);
        tv_privacy_two =(TextView)findViewById(R.id.tv_privacy_two);
        tv_privacy_three =(TextView)findViewById(R.id.tv_privacy_three);
        tv_privacy_four =(TextView)findViewById(R.id.tv_privacy_four);
        tv_privacy_five =(TextView)findViewById(R.id.tv_privacy_five);
        tv_privacy_six =(TextView)findViewById(R.id.tv_privacy_six);
        tv_privacy_seven =(TextView)findViewById(R.id.tv_privacy_seven);

        tv_privacy_one.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_privacy_two.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Bold.otf"));
        tv_privacy_three.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_privacy_four.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Bold.otf"));
        tv_privacy_five.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_privacy_six.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Bold.otf"));
        tv_privacy_seven.setTypeface(Fonts.getTypefaceTwo(PrivacyPolicyActivity.this, "SF-Pro-Display-Regular.otf"));

        back_arrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }


    }
