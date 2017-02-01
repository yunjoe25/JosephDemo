package com.kjdy.josephdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kjdy.josephdemo.R;

/**
 * Created by yunjo on 1/25/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private Context mContext;

    public ListViewAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //called once when adapter was called.
    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //called by the number of view that exists in the view
    //refreshed & called when we scroll the list to see new numbers
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //
//        TextView view = new TextView(mContext);
//        view.setText(String.valueOf(position));
//        return view;

        // called once initially
        //** Important to load time of the list **
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();
            holder.textView1 = (TextView)convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView)convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView)convertView.findViewById(R.id.list_view_tv3);
            convertView.setTag(holder);
        }
        else{
            //getTag() returns object => cast ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));

        if(position%2 == 0){
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);
        } else{
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
        }


//        View rowView = mInflater.inflate(R.layout.list_item,parent,false);
//        TextView textView = (TextView)rowView.findViewById(R.id.list_view_tv);
//        textView.setText(String.valueOf(position));

        //making a toast in adapter
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return convertView;
    }
}
//Store all objects, for this instance we save list view
class  ViewHolder{
    TextView textView1;
    TextView textView2;
    TextView textView3;


}