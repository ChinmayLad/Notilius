package com.maverick.applications.notilius.ui.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maverick.applications.notilius.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chinmay on 28/1/18.
 */

public class BitcoinViewHolder extends RecyclerView.ViewHolder {

    public static final String icon_url = "https://files.coinmarketcap.com/static/img/coins/64x64";

    @BindView(R.id.item_icon) ImageView icon;
    @BindView(R.id.bitcoin_title) TextView name;

    public BitcoinViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
