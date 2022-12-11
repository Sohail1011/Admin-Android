package com.example.admin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.admin.Adapters.AdapterRoom;
import com.example.admin.Entities.Room;
import com.example.admin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoomsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomsFragment extends Fragment {

    AdapterRoom adapterRoom;
    RecyclerView recyclerViewRooms;
    ArrayList<Room> listRooms;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RoomsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoomsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoomsFragment newInstance(String param1, String param2) {
        RoomsFragment fragment = new RoomsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        recyclerViewRooms = view.findViewById(R.id.lstRooms);
        listRooms = new ArrayList<>();
        // load the list
        loadList();
        // show data
        showData();
        return view;
    }

    public void loadList() {
        listRooms.add(new Room("203", "Piso 2", "Disponible"));
        listRooms.add(new Room("104", "Piso 1", "Disponible"));
        listRooms.add(new Room("302", "Piso 3", "Ocupado"));
        listRooms.add(new Room("202", "Piso 2", "Disponible"));
        listRooms.add(new Room("105", "Piso 1", "Ocupado"));
    }

    public void showData() {
        recyclerViewRooms.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterRoom = new AdapterRoom(getContext(), listRooms);
        recyclerViewRooms.setAdapter(adapterRoom);

        adapterRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = listRooms.get(recyclerViewRooms.getChildAdapterPosition(view)).getNumber();
                Toast.makeText(getContext(), "Selecciono: " + number, Toast.LENGTH_SHORT).show();
            }
        });
    }
}