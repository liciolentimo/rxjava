package com.lentimosystems.rxjava;

/**
 * Created by LICIO on 4/19/2018.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

class StockUpdateViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_stock_item_symbol)
    TextView stockSymbol;

    public StockUpdateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
