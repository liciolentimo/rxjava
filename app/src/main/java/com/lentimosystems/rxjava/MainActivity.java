package com.lentimosystems.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    TextView helloText;
    RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = findViewById(R.id.tv_hello);

        recyclerView = findViewById(R.id.rv_stock_updates);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        stockDataAdapter = new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);



        Observable.just("Hello! Please use this app responsibly")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        helloText.setText(s);

                        Observable.just("APPL" ,"GOOGL", "TWTR")
                                .subscribe(new Consumer<String>() {
                                    @Override
                                    public void accept(String stockSymbol) throws Exception {
                                        stockDataAdapter.add(stockSymbol);
                    }
                });
    }
});
    }
}