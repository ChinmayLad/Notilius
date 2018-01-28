package com.maverick.applications.notilius.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.maverick.applications.notilius.models.CoinData;
import com.maverick.applications.notilius.ui.viewholders.BitcoinViewHolder;

import java.util.List;

/**
 * Created by chinmay on 28/1/18.
 */

public class BitcointListAdapter extends RecyclerView.Adapter{

    List<CoinData> data;
    Context context;

    public BitcointListAdapter(List<CoinData> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BitcoinViewHolder.inflateView(parent,context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BitcoinViewHolder) holder).bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
