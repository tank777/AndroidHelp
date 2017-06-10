package com.galtech.alibawa.order.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.galtech.alibawa.R;
import com.galtech.alibawa.order.model.CountryInfo;

import java.util.List;

/**
 * Created by Bhavesh on 23-03-2017.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {
    private Context context;
    private List countryBeen;
    CountryInfo.CountryBean tempValues=null;
    LayoutInflater inflater;

    public SpinnerAdapter(Context context, int spinner_item, List countryBeen) {
        super(context,spinner_item,countryBeen);
        this.context = context;
        this.countryBeen = countryBeen;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {


        View row = inflater.inflate(R.layout.spinner_item, parent, false);


        tempValues = null;
        tempValues = (CountryInfo.CountryBean) countryBeen.get(position);

        TextView label = (TextView)row.findViewById(R.id.tv_country);

            label.setText(tempValues.getCountry());


        return row;
    }
}
