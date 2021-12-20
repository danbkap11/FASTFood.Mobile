package com.nure.bearer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nure.bearer.Cells;
import com.nure.bearer.Machins;
import com.nure.bearer.MainActivity;
import com.nure.bearer.R;

import java.util.ArrayList;

import static com.nure.bearer.Helper.RestHelper.cellList;

public class MachinsAdapter extends ArrayAdapter<Machine> {


    public MachinsAdapter(@NonNull Context context, ArrayList<Machine> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.machins_array, parent, false);
        }
        Machine currentNumberPosition = getItem(position);

        currentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click+" + position);
                cellList = (ArrayList<Cell>) currentNumberPosition.getListOfCells();
                Context c = getContext();
                Intent intent = new Intent(c, Cells.class);
                c.startActivity(intent);

            }
        });


        TextView machineName = currentItemView.findViewById(R.id.machineName);
        machineName.setText("Machine Name"+currentNumberPosition.getName());
        TextView machineLocation = currentItemView.findViewById(R.id.machineLocation);
        machineLocation.setText("Machine location"+currentNumberPosition.getLocation());
        TextView machineSale = currentItemView.findViewById(R.id.machineSale);
        if (currentNumberPosition.getListOfCells() == null) {
            machineSale.setText("NO CELLS");
        } else
            machineSale.setText("Total cells"+currentNumberPosition.getListOfCells().size());
        return currentItemView;
    }

}
