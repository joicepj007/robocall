package robocall.com.robocall.Activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import robocall.com.robocall.Adapter.CallLogAdpter;
import robocall.com.robocall.R;

public class NavContactActivity extends RootActivity{

    private Context mContext;
    private ListView listview1;
    CallLogAdpter callLogAdpter;
    ArrayList<String> StoreContacts ;
    ArrayAdapter<String> arrayAdapter ;
    Cursor cursor ;
    String name, phonenumber ;
    public  static final int RequestPermissionCode  = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_contact_activity);
        mContext = this;

        listview1 =(ListView)findViewById(R.id.listview1);

        StoreContacts = new ArrayList<String>();

        EnableRuntimePermission();
        StoreContacts.clear();
        GetContactsIntoArrayList();

        arrayAdapter = new ArrayAdapter<String>(
                NavContactActivity.this,
                R.layout.contact_items_listview,
                R.id.textView, StoreContacts
        );

        listview1.setAdapter(arrayAdapter);
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
                NavContactActivity.this,
                Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(NavContactActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(NavContactActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(NavContactActivity.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(NavContactActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
