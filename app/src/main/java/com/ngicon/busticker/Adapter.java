package com.ngicon.busticker;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<BusItems> buses;

    public Adapter(Context ctx, List<BusItems> bueses){
        this.inflater = LayoutInflater.from(ctx);
        this.buses = bueses;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_search_result,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.bus_name.setText(buses.get(position).getBus_name());
        holder.dep_time.setText(buses.get(position).getDep_time());
        holder.seat_available.setText(buses.get(position).getSeat_available());
        holder.fare.setText(buses.get(position).getFare());

    }

    @Override
    public int getItemCount() {
        return buses.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView bus_name ,dep_time, seat_available, fare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bus_name = itemView.findViewById(R.id.bus_name);
            dep_time = itemView.findViewById(R.id.dep_time);
            seat_available = itemView.findViewById(R.id.seat_available);
            fare = itemView.findViewById(R.id.fare);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}