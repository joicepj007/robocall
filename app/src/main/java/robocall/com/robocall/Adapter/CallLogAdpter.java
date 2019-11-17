package robocall.com.robocall.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import robocall.com.robocall.R;

public class CallLogAdpter extends BaseAdapter {

    private Context mActivity;
    private static LayoutInflater inflater = null;
    private CallLogAdpter.ViewHolder holder = null;
    private ArrayList<HashMap<String, String>> mData = new ArrayList<HashMap<String, String>>();


    public CallLogAdpter(Context mContext, ArrayList<HashMap<String, String>> callLog) {
        mActivity = mContext;
        mData = callLog;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        return 6;
    }

    @Override
    public Object getItem(int i) {

        return i;
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    class ViewHolder {


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View vi = view;
        if (view == null) {
            // vi = inflater.inflate(R.layout.horizontal_list_item, null);
            vi = inflater.inflate(R.layout.call_log_row, null);
            holder = new CallLogAdpter.ViewHolder();

            vi.setTag(holder);

        }

        else {
            holder = (CallLogAdpter.ViewHolder) vi.getTag();
        }

        return vi;
    }
}
