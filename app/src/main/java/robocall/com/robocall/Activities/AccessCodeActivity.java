package robocall.com.robocall.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import robocall.com.robocall.R;
import robocall.com.robocall.Util.Fonts;

public class AccessCodeActivity extends RootActivity {

    private Context mContext;
    private RelativeLayout r_layout_continue;
    private TextView tv_enter_code, tv_verify_code;
    private EditText edt_code_one, edt_code_two, edt_code_three, edt_code_four;
    String codeOne, codeTwo, codeThree, codeFour, fullCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access_code_activity);
        mContext = this;

        r_layout_continue =(RelativeLayout)findViewById(R.id.r_layout_continue);
        tv_enter_code =(TextView)findViewById(R.id.tv_enter_code);
        edt_code_one =(EditText) findViewById(R.id.edt_code_one);
        edt_code_two =(EditText) findViewById(R.id.edt_code_two);
        edt_code_three =(EditText) findViewById(R.id.edt_code_three);
        edt_code_four =(EditText) findViewById(R.id.edt_code_four);
        tv_verify_code =(TextView)findViewById(R.id.tv_verify_code);

        tv_enter_code.setTypeface(Fonts.getTypefaceTwo(AccessCodeActivity.this, "SF-Pro-Display-Regular.otf"));
        tv_verify_code.setTypeface(Fonts.getTypefaceTwo(AccessCodeActivity.this, "SF-Pro-Display-Bold.otf"));


        edt_code_one.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = edt_code_one.getText().length();

                if (textlength1 >= 1) {
                    edt_code_two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
        edt_code_two.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = edt_code_two.getText().length();

                if (textlength1 >= 1) {
                    edt_code_three.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

        edt_code_three.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = edt_code_three.getText().length();

                if (textlength1 >= 1) {
                    edt_code_four.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

        edt_code_four.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = edt_code_four.getText().length();

                if (textlength1 >= 1) {
                    //AccessCodeDigit4.requestFocus();




                    try {
                        codeOne = edt_code_one.getText().toString();
                        codeTwo = edt_code_two.getText().toString();
                        codeThree = edt_code_three.getText().toString();
                        codeFour = edt_code_four.getText().toString();
                        fullCode = codeOne + codeTwo + codeThree + codeFour;
                        // mProgressHUD = ProgressHud.show(AccessCodeActivity.this, true, false, AccessCodeActivity.this);
                            /*showBusyAnimation();
                            new accessCode().execute("0");*/
                    } catch (Exception e) {

                    }

                } else {
                    // Toast.makeText(AccessCodeActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });


        r_layout_continue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                codeOne = edt_code_one.getText().toString().trim();
                codeTwo = edt_code_two.getText().toString().trim();
                codeThree = edt_code_three.getText().toString().trim();
                codeFour = edt_code_four.getText().toString().trim();

                if (edt_code_one.getText().toString().trim().length() != 0 || edt_code_two.getText().toString().trim().length() != 0 ||
                        edt_code_three.getText().toString().trim().length() != 0 || edt_code_four.getText().toString().trim().length() != 0) {

                    if (edt_code_one.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please enter first code", Toast.LENGTH_LONG).show();

                    } else if (edt_code_two.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please enter second code", Toast.LENGTH_LONG).show();
                    } else if (edt_code_three.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please enter third code", Toast.LENGTH_LONG).show();
                    } else if (edt_code_four.getText().toString().trim().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please enter fourth code", Toast.LENGTH_LONG).show();
                    } else {


                        fullCode = codeOne + codeTwo + codeThree + codeFour;
                        Intent intent = new Intent(mContext, HomeScreenActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
                else {

                    Toast.makeText(getApplicationContext(),"Please enter otp code",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
