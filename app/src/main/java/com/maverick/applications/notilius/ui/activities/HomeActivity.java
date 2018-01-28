package com.maverick.applications.notilius.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maverick.applications.notilius.R;
import com.maverick.applications.notilius.models.CoinData;
import com.maverick.applications.notilius.ui.adapter.BitcointListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by chinmay on 21/1/18.
 */

public class HomeActivity extends Activity {

    private List<CoinData> data;

    @Nullable
    @BindView(R.id.bitcoin_list)
    RecyclerView mBitcointList;
    @Nullable
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Nullable
    @BindView(R.id.navigation_layout)
    RecyclerView mNavigationLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initViews();
        loadData();

    }

    private void loadData() {
        String url = "https://api.coinmarketcap.com/v1/ticker/";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        data =  new Gson().fromJson(response,new TypeToken<List<CoinData>>(){}.getType());
                        BitcointListAdapter bitcointListAdapter = new BitcointListAdapter(data,HomeActivity.this);
                        mBitcointList.setAdapter(bitcointListAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }

    private void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mBitcointList.setLayoutManager(layoutManager);
    }

}
