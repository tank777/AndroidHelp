package com.galtech.alibawa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;

import com.galtech.alibawa.R;
import com.galtech.alibawa.interfaces.OnCurrencyClickListener;
import com.galtech.alibawa.model.CurrencyInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 04-04-2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

    private Context context;
    private List<CurrencyInfo.CurrencyBean> currencyBeen;
    private int lastCheckedPosition;
    private OnCurrencyClickListener onCurrencyClickListener;


    public CurrencyAdapter(Context context, List<CurrencyInfo.CurrencyBean> currencyBeen, int position, OnCurrencyClickListener onCurrencyClickListener) {

        this.context = context;
        this.currencyBeen = currencyBeen;
        this.lastCheckedPosition = position;
        this.onCurrencyClickListener = onCurrencyClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_currency, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        CurrencyInfo.CurrencyBean info = currencyBeen.get(position);
        if (info != null) {
            holder.tvCurrency.setText(info.getName_plural() + "\t\t" + info.getCode() + "\t\t" + info.getSymbol_native());
            holder.tvCurrency.setChecked(position == lastCheckedPosition);
        }

    }

    @Override
    public int getItemCount() {
        return currencyBeen != null ? currencyBeen.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_currency)
        CheckBox tvCurrency;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvCurrency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastCheckedPosition = getAdapterPosition();
                    notifyItemRangeChanged(0, currencyBeen.size());
                    onCurrencyClickListener.onCurrencyClick(currencyBeen.get(getAdapterPosition()));
                }
            });
        }
    }

}
