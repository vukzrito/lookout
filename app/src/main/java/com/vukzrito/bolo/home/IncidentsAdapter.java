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
import com.vukzrito.bolo.model.Incident;

import java.util.List;

public class IncidentsAdapter extends RecyclerView.Adapter<IncidentsAdapter.ViewHolder> {
    List<Incident> incidents;
    private Context context;
    private IncidentItemListener itemClickListener;

    IncidentsAdapter(IncidentItemListener itemClickListener) {
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
        Incident incident = incidents.get(position);
        if (incident.getVehicle() != null) {
            holder.titleTextView.setText(String.format("%s %s", incident.getVehicle().getMake(), incident.getVehicle().getModel()));
            Picasso.with(context).load(incident.getVehicle().getImageUrl())
                    .error(R.drawable.ic_directions_car_black)
                    .fit()
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        if (incidents == null) {
            return 0;
        }
        return incidents.size();
    }

    void updateData(List<Incident> incidents) {
        this.incidents = incidents;
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        ImageView imageView;
        IncidentItemListener itemClickListener;

        ViewHolder(View itemView, IncidentItemListener itemClickListener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.vehicle_list_item_title);
            imageView = itemView.findViewById(R.id.vehicle_list_item_image);
            itemView.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Incident incident = incidents.get(position);
            itemClickListener.onIncidentClicked(incident);
        }
    }
}
