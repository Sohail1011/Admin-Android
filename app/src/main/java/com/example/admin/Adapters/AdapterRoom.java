package com.example.admin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.Entities.Room;
import com.example.admin.R;

import java.util.ArrayList;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Room> model;

    //listener
    private View.OnClickListener listener;

    public AdapterRoom(Context context, ArrayList<Room> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_elements, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String number = model.get(position).getNumber();
        String floor = model.get(position).getFloor();
        String state = model.get(position).getState();
        holder.number.setText(number);
        holder.floor.setText(floor);
        holder.state.setText(state);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, floor, state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.numberRoom);
            floor = itemView.findViewById(R.id.description);
            state = itemView.findViewById(R.id.readiness);
        }
    }
}
