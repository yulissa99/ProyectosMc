package com.uca.apps.isi.nct.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uca.apps.isi.nct.R;

/**
 * Created by Administrador on 09/10/2017.
 */

public class MyComplaintAdapter extends RecyclerView.Adapter<MyComplaintAdapter.ViewHolder>{

    private String[] titles;
    private String[] urls;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        //Mapea las vistas
        public SimpleDraweeView image;
        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            image = view.findViewById(R.id.image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyComplaintAdapter(String[] titles, String[] urls) {
        this.titles = titles;
        this.urls = urls;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyComplaintAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_complaint_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        MyComplaintAdapter.ViewHolder vh = new MyComplaintAdapter.ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyComplaintAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(titles[position]);
        holder.image.setImageURI(urls[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return titles.length;
    }
}
