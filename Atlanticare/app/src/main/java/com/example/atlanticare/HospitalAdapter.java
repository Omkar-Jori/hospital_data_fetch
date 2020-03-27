package com.example.atlanticare;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class HospitalAdapter extends ArrayAdapter<HospitalData> {

    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView description;
        TextView charge;
    }


    public HospitalAdapter(Context context, int resource, ArrayList<HospitalData> objects) {
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String description = getItem(position).getDescription();
        String charge = getItem(position).getCharge();

        //Create the person object with the information
        HospitalData hospitalData = new HospitalData(description,charge);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.description = convertView.findViewById(R.id.textView1);
            holder.charge = convertView.findViewById(R.id.textView2);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.description.setText(hospitalData.getDescription());
        holder.charge.setText(hospitalData.getCharge());

        return convertView;
    }

}
