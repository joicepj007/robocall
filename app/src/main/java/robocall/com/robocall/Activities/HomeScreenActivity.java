package robocall.com.robocall.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import robocall.com.robocall.Adapter.CallLogAdpter;
import robocall.com.robocall.R;
import robocall.com.robocall.navigationDrawer.FragmentDrawer;

public class HomeScreenActivity extends RootActivity implements FragmentDrawer.FragmentDrawerListener {

    private Context mContext;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout linear_call, linear_contact, linear_additional_light, linear_block_light;
    private ImageView img_call, img_contact, img_additional_light, img_block_light;
    private View view_call, view_contact, view_additional_light, view_block_light;
    private ListView listview1, listview2, listview3, listview4;
    private TextView tv_calllog;
    private FloatingActionButton btn_dial, btn_contact;
    boolean doubleBackToExitPressedOnce = false;
    CallLogAdpter callLogAdpter;
    ArrayList<String> StoreContacts ;
    ArrayAdapter<String> arrayAdapter ;
    Cursor cursor ;
    String name, phonenumber ;
    public  static final int RequestPermissionCode  = 1 ;
    private ArrayList<HashMap<String,String>> callLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);
        mContext = this;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        linear_call = (LinearLayout)findViewById(R.id.linear_call);
        linear_contact = (LinearLayout)findViewById(R.id.linear_contact);
        linear_additional_light = (LinearLayout)findViewById(R.id.linear_additional_light);
        linear_block_light = (LinearLayout)findViewById(R.id.linear_block_light);

        img_call = (ImageView)findViewById(R.id.img_call);
        img_contact = (ImageView)findViewById(R.id.img_contact);
        img_additional_light = (ImageView)findViewById(R.id.img_additional_light);
        img_block_light = (ImageView)findViewById(R.id.img_block_light);

        view_call = (View)findViewById(R.id.view_call);
        view_contact = (View)findViewById(R.id.view_contact);
        view_additional_light = (View)findViewById(R.id.view_additional_light);
        view_block_light = (View)findViewById(R.id.view_block_light);

        listview1 = (ListView)findViewById(R.id.listview1);
        listview2 = (ListView)findViewById(R.id.listview2);
        listview3 = (ListView)findViewById(R.id.listview3);
        listview4 = (ListView)findViewById(R.id.listview4);

        tv_calllog = (TextView)findViewById(R.id.tv_calllog);

        btn_dial = (FloatingActionButton)findViewById(R.id.btn_dial);
        btn_contact = (FloatingActionButton)findViewById(R.id.btn_contact);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        StoreContacts = new ArrayList<String>();

        EnableRuntimePermission();
        EnableCallLogPermission();

        btn_dial.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:9999999999"));
                startActivity(intent);

            }
        });

       /* mToolbar.setTitle("Title");
        mToolbar.setSubtitle("Sub");
        mToolbar.setLogo(R.drawable.account_menu);*/

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);




        mToolbar.setNavigationIcon(R.drawable.menu_icon);
        mToolbar.invalidate();
        // display the first navigation drawer view on app launch
      //  displayView(0);

        img_call.setBackground(ContextCompat.getDrawable(mContext,R.drawable.call));
        view_call.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
        listview1.setVisibility(View.VISIBLE);
        tv_calllog.setVisibility(View.VISIBLE);
        tv_calllog.setText("CALL LOG");

        img_contact.setBackground(ContextCompat.getDrawable(mContext,R.drawable.contact_light));
        view_contact.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        listview2.setVisibility(View.GONE);

        img_additional_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.aditional_light));
        view_additional_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        listview3.setVisibility(View.GONE);

        img_block_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.block_light));
        view_block_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        listview4.setVisibility(View.GONE);

        btn_dial.setVisibility(View.VISIBLE);
        btn_contact.setVisibility(View.GONE);

        // callLog=getCallLog();
        callLogAdpter = new CallLogAdpter(mContext,callLog);
        listview1.setAdapter(callLogAdpter);
        callLogAdpter.notifyDataSetChanged();

        linear_call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                img_call.setBackground(ContextCompat.getDrawable(mContext,R.drawable.call));
                view_call.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
                listview1.setVisibility(View.VISIBLE);
                tv_calllog.setVisibility(View.VISIBLE);
                tv_calllog.setText("CALL LOG");

                img_contact.setBackground(ContextCompat.getDrawable(mContext,R.drawable.contact_light));
                view_contact.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview2.setVisibility(View.GONE);

                img_additional_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.aditional_light));
                view_additional_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview3.setVisibility(View.GONE);

                img_block_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.block_light));
                view_block_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview4.setVisibility(View.GONE);

                btn_dial.setVisibility(View.VISIBLE);
                btn_contact.setVisibility(View.GONE);

               // callLog=getCallLog();
                callLogAdpter = new CallLogAdpter(mContext,callLog);
                listview1.setAdapter(callLogAdpter);
                callLogAdpter.notifyDataSetChanged();
            }
        });

        linear_contact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                img_call.setBackground(ContextCompat.getDrawable(mContext,R.drawable.call_light));
                view_call.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview1.setVisibility(View.GONE);
                tv_calllog.setVisibility(View.VISIBLE);
                tv_calllog.setText("CONTACTS");

                img_contact.setBackground(ContextCompat.getDrawable(mContext,R.drawable.contact));
                view_contact.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
                listview2.setVisibility(View.VISIBLE);

                img_additional_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.aditional_light));
                view_additional_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview3.setVisibility(View.GONE);

                img_block_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.block_light));
                view_block_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview4.setVisibility(View.GONE);

                btn_dial.setVisibility(View.GONE);
                btn_contact.setVisibility(View.VISIBLE);
                StoreContacts.clear();
                GetContactsIntoArrayList();

                arrayAdapter = new ArrayAdapter<String>(
                        HomeScreenActivity.this,
                        R.layout.contact_items_listview,
                        R.id.textView, StoreContacts
                );

                listview2.setAdapter(arrayAdapter);
            }
        });

        listview2.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent=new Intent(HomeScreenActivity.this,CallDetailActivity.class);
            startActivity(intent);

            }
        });

        linear_additional_light.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                img_call.setBackground(ContextCompat.getDrawable(mContext,R.drawable.call_light));
                view_call.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview1.setVisibility(View.GONE);
                tv_calllog.setVisibility(View.GONE);
                tv_calllog.setText(" ");

                img_contact.setBackground(ContextCompat.getDrawable(mContext,R.drawable.contact_light));
                view_contact.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview2.setVisibility(View.GONE);


                img_additional_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.aditional));
                view_additional_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
                listview3.setVisibility(View.VISIBLE);

                img_block_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.block_light));
                view_block_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview4.setVisibility(View.GONE);

                btn_dial.setVisibility(View.GONE);
                btn_contact.setVisibility(View.GONE);

            }
        });

        linear_block_light.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                img_call.setBackground(ContextCompat.getDrawable(mContext,R.drawable.call_light));
                view_call.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview1.setVisibility(View.GONE);
                tv_calllog.setVisibility(View.GONE);
                tv_calllog.setText(" ");

                img_contact.setBackground(ContextCompat.getDrawable(mContext,R.drawable.contact_light));
                view_contact.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview2.setVisibility(View.GONE);


                img_additional_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.aditional_light));
                view_additional_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                listview3.setVisibility(View.GONE);

                img_block_light.setBackground(ContextCompat.getDrawable(mContext,R.drawable.block));
                view_block_light.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWhite));
                listview4.setVisibility(View.VISIBLE);

                btn_dial.setVisibility(View.GONE);
                btn_contact.setVisibility(View.GONE);

            }
        });

    }

    private void EnableCallLogPermission() {



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


    @Override
    public void onDrawerItemSelected(View view, int position) {
        //displayView(position);
    }


    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            StoreContacts.add(name);
            //StoreContacts.add(phonenumber);
        }

        cursor.close();

    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                HomeScreenActivity.this,
                Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(HomeScreenActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(HomeScreenActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(HomeScreenActivity.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(HomeScreenActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    public ArrayList<HashMap<String,String>> getCallLog()
    {


        ArrayList<HashMap<String,String>> callLog=new ArrayList<HashMap<String,String>>();
        CursorLoader cursorLoader=new CursorLoader(mContext, CallLog.Calls.CONTENT_URI, null, null, null, null);
        Cursor cursor=cursorLoader.loadInBackground();
        if(cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                HashMap<String,String> hashMap=new HashMap<String, String>();
                hashMap.put(CallLog.Calls.NUMBER, cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER)));
                hashMap.put(CallLog.Calls.DATE, cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE)));
                hashMap.put(CallLog.Calls.DURATION, cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION)));
                callLog.add(hashMap);
            }
        }
        return callLog;
    }


}
