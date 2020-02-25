package edu.depaul.knowyourgovernment.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.depaul.knowyourgovernment.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView officeTextView;
    public TextView officialNameTextView;

    MyViewHolder(View view) {
        super(view);
        officeTextView =view.findViewById(R.id.officeTextView);
        officialNameTextView=view.findViewById(R.id.officialNameTextView);


    }
}
