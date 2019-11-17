package robocall.com.robocall.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import robocall.com.robocall.R;

public class CallDetailActivity extends RootActivity {

    private Context mContext;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_detail_activity);
        mContext = this;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);


    }

}