package com.vukzrito.bolo.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder>  {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
