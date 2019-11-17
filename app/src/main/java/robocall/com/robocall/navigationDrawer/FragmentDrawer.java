package robocall.com.robocall.navigationDrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import robocall.com.robocall.Activities.NavContactActivity;
import robocall.com.robocall.Activities.PhoneNumberActivity;
import robocall.com.robocall.Activities.PrivacyPolicyActivity;
import robocall.com.robocall.Controller.AppSession;
import robocall.com.robocall.R;

public class FragmentDrawer extends Fragment {



    private static String TAG = FragmentDrawer.class.getSimpleName();

    private Context mContext;
    private FragmentDrawerListener drawerListener;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private View containerView;
    View mView;
    private LinearLayout linear_privacy, linear_calls, linear_contact, linear_setting;
    private TextView tv_sign_out, tv_phone;

    public FragmentDrawer() {

    }
    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        // Inflating view layout
        mView = inflater.inflate(R.layout.navigation_drawer, container, false);

        linear_calls = (LinearLayout)mView.findViewById(R.id.linear_calls);
        linear_contact = (LinearLayout)mView.findViewById(R.id.linear_contact);
        linear_setting = (LinearLayout)mView.findViewById(R.id.linear_setting);
        linear_privacy = (LinearLayout)mView.findViewById(R.id.linear_privacy);
        tv_sign_out = (TextView) mView.findViewById(R.id.tv_sign_out);
        tv_phone = (TextView) mView.findViewById(R.id.tv_phone);

        tv_phone.setText(AppSession.getInstance().getPhone_Number());

        linear_privacy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(), PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

        tv_sign_out.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getActivity(), PhoneNumberActivity.class);
                startActivity(intent);
            }
        });
        linear_contact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getActivity(), NavContactActivity.class);
                startActivity(intent);

            }
        });

        linear_setting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(callGPSSettingIntent);
            }
        });

        return mView;
    }


    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                // mDrawerToggle.syncState();
            }
        });

    }
}