package edu.depaul.knowyourgovernment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.depaul.knowyourgovernment.R;
import edu.depaul.knowyourgovernment.activities.MainActivity;
import edu.depaul.knowyourgovernment.models.DummyObj;

public class CivicDataAdapter extends RecyclerView.Adapter <MyViewHolder> {

    private MainActivity mainAct;

    private List <DummyObj> officialList;

    public CivicDataAdapter(List<DummyObj> officialList, MainActivity mainAct) {
        this.officialList=officialList;
        this.mainAct=mainAct;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.officials_row_list, parent, false);

        itemView.setOnClickListener(mainAct);
        //itemView.setOnLongClickListener(mainAct);

        return new MyViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DummyObj official =officialList.get(position);

        holder.officeTextView.setText(official.getOffice());
        holder.officialNameTextView.setText(official.getName()+"("+official.getParty()+")");

    }

    @Override
    public int getItemCount() {
        return officialList.size();
    }
}
