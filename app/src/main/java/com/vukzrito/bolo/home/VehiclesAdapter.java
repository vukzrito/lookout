package com.vukzrito.bolo.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vukzrito.bolo.R;
import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {
    List<Vehicle> vehicles;
    private Context context;
    private VehicleItemListener itemClickListener;

    VehiclesAdapter(VehicleItemListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.vehicles_list_item_row, parent, false);
        return new ViewHolder(articleView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Vehicle vehicle = vehicles.get(position);
        holder.titleTextView.setText(String.format("%s %s", vehicle.getMake(), vehicle.getModel()));
        Picasso.with(context).load(vehicle.getImageUrl())
                .error(R.drawable.ic_directions_car_black)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (vehicles == null) {
            return 0;
        }
        return vehicles.size();
    }

    void updateData(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        ImageView imageView;
        VehicleItemListener itemClickListener;

        ViewHolder(View itemView, VehicleItemListener itemClickListener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.vehicle_list_item_title);
            imageView = itemView.findViewById(R.id.vehicle_list_item_image);
            itemView.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Vehicle vehicle = vehicles.get(position);
            itemClickListener.onVehicleClicked(vehicle);
        }
    }
}
