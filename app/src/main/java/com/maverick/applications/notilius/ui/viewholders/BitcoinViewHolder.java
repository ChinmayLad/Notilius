package com.maverick.applications.notilius.ui.viewholders;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maverick.applications.notilius.R;
import com.maverick.applications.notilius.models.CoinData;
import com.maverick.applications.notilius.ui.adapter.BitcointListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chinmay on 28/1/18.
 */

public class BitcoinViewHolder extends RecyclerView.ViewHolder {

    private static final String icon_url = "https://files.coinmarketcap.com/static/img/coins/64x64/";
    private Context context;

    @Nullable
    @BindView(R.id.item_icon) ImageView icon;
    @Nullable
    @BindView(R.id.bitcoin_title) TextView name;

    public BitcoinViewHolder(View itemView,Context context) {
        this(itemView);
        this.context = context;
    }

    public BitcoinViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindView(CoinData coinData) {
        Glide.with(context)
                .load(icon_url + coinData.getId() + ".png")
                .into(icon);
        name.setText(coinData.getName());
    }

    public static BitcoinViewHolder inflateView(ViewGroup parent, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bitcoin,parent,false);
        return new BitcoinViewHolder(view,context);
    }
}
