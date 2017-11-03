package com.uca.apps.isi.nct.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uca.apps.isi.nct.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.uca.apps.isi.nct.activities.ComplaintAddActivity;
import com.uca.apps.isi.nct.Adapters.ComplaintsAdapter;
import com.uca.apps.isi.nct.api.Api;
import com.uca.apps.isi.nct.models.Complaint;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComplaintsFragment extends Fragment {

    private RecyclerView recyclerView;


    public ComplaintsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complaints, container, false);

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

        String[] titles = new String[1];
        titles[0] = "Yulissa Pérez";

        String[] urls = new String[10];
        urls[0] = "https://lh6.googleusercontent.com/vtYFbZ_QDJ_NBvJsC18rV_IwHxYYcNTfXovLQooPxJVGuJJ2eE7GnJDAe5ZfHFYlRTWCknCTPYm-Z_Y=w1366-h613-rw";

        Call<List<Complaint>> call = Api.instance().getComplaints();
        call.enqueue(new Callback<List<Complaint>>() {
            @Override
            public void onResponse(Call<List<Complaint>> call, Response<List<Complaint>> response) {
                if(response.body() != null) {
                    ComplaintsAdapter complaintsAdapter = new ComplaintsAdapter(response.body());
                    recyclerView.setAdapter(complaintsAdapter);

                    Intent intent = new Intent(getContext(), ComplaintAddActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<List<Complaint>> call, Throwable t) {
                Log.e("xD", t.getMessage());

            }
        });
    }
}
