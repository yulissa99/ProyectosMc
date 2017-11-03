package com.uca.apps.isi.nct.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uca.apps.isi.nct.Adapters.MyComplaintAdapter;
import com.uca.apps.isi.nct.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyComplaintsFragment extends Fragment {

    private RecyclerView recyclerView;


    public MyComplaintsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_complaints, container, false);

        //Call init method

        init(view);

        return view;
    }

    /**
     * This method instance variables
     * @param view
     */

    private void init(View view){
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        String[] titles = new String[3];
        titles[0] = "Tubería Rota";
        titles[1] = "Animal en el agua";
        titles[2] = "Basura en las alcantarillas";


        String[] urls = new String[10];
        urls[0] = "http://analisisrealista.com/wp-content/uploads/2014/04/tuber%C3%ADa-rota.jpg";
        urls[1] = "https://c2.staticflickr.com/4/3695/10934991046_b22963c5b7_b.jpg";
        urls[2] = "https://contactohoy.com.mx/wp-content/uploads/2016/04/Basura-alcantarilla-min.jpg";

        MyComplaintAdapter myComplaintAdapter = new MyComplaintAdapter(titles, urls);
        recyclerView.setAdapter(myComplaintAdapter);
    }

}
