package robocall.com.robocall.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import robocall.com.robocall.Controller.AppSession;
import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class PhoneNumberActivity extends RootActivity {

    private Context mContext;
    private RelativeLayout r_layout_next;
    private TextView tv_enter_phone, tv_below_enter_phone, tv_continue;
    private EditText tv_code, tv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_number_activity);
        mContext = this;

        r_layout_next =(RelativeLayout)findViewById(R.id.r_layout_next);
        tv_enter_phone = (TextView)findViewById(R.id.tv_enter_phone);
        tv_below_enter_phone = (TextView)findViewById(R.id.tv_below_enter_phone);
        tv_continue = (TextView)findViewById(R.id.tv_continue);
        tv_phone = (EditText) findViewById(R.id.tv_phone);
        tv_code = (EditText) findViewById(R.id.tv_code);

        tv_enter_phone.setTypeface(Fonts.getTypefaceTwo(PhoneNumberActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_phone.setTypeface(Fonts.getTypefaceTwo(PhoneNumberActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_code.setTypeface(Fonts.getTypefaceTwo(PhoneNumberActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_below_enter_phone.setTypeface(Fonts.getTypefaceTwo(PhoneNumberActivity.this, "SF-Pro-Display-Medium.otf"));
        tv_continue.setTypeface(Fonts.getTypefaceTwo(PhoneNumberActivity.this, "SF-Pro-Display-Bold.otf"));


        r_layout_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tv_code.getText().toString().trim().length() != 0 ||tv_phone.getText().toString().trim().length() != 0 ){

                    if (tv_code.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(),"Please enter the country code",Toast.LENGTH_LONG).show();
                    }
                    else if (tv_phone.getText().toString().trim().length() < 7){
                        Toast.makeText(getApplicationContext(),"Please enter phone number atleast 7 digits",Toast.LENGTH_LONG).show();
                    }

                    else if (tv_phone.getText().toString().trim().length()  > 13){
                        Toast.makeText(getApplicationContext(),"Please enter phone number less than or equals 13 digits",Toast.LENGTH_LONG).show();
                    }

                    else {


                        String code = tv_code.getText().toString();
                        String phone = tv_phone.getText().toString();

                        AppSession.getInstance().setPhone_Number(code+ " "+phone);

                        Intent intent = new Intent(mContext,AccessCodeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

                else {

                    Toast.makeText(getApplicationContext(),"Please fill the fields",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
