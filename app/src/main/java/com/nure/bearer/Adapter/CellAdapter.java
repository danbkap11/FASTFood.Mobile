package com.nure.bearer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nure.bearer.Helper.RestHelper;
import com.nure.bearer.R;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CellAdapter extends ArrayAdapter<Cell> {


    Thread thread;
    OkHttpClient client = new OkHttpClient();

    public CellAdapter(@NonNull Context context, ArrayList<Cell> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.cell_array, parent, false);
        }
        Cell currentNumberPosition = getItem(position);

        TextView cellStatus = currentItemView.findViewById(R.id.cellStatus);
        TextView cellNumber2 = currentItemView.findViewById(R.id.cellNumber2);
        cellNumber2.setText("Cell: "+currentNumberPosition.getNumber());
        cellStatus.setText("Status: "+currentNumberPosition.getStatus());
        TextView cellPrice = currentItemView.findViewById(R.id.cellPrice);
        TextView cellShelfLife = currentItemView.findViewById(R.id.cellShelfLife);
        TextView cellFoodName = currentItemView.findViewById(R.id.cellFoodName);
        TextView cellWeight = currentItemView.findViewById(R.id.cellWeight);
        if (!currentNumberPosition.getStatus().equals("EMPTY")) {

            cellPrice.setText("Price: " + currentNumberPosition.getPrice());
            cellShelfLife.setText(currentNumberPosition.getShelfLife());
            cellFoodName.setText("Food: " + currentNumberPosition.getFoodName());
            cellWeight.setText("Weight: "+currentNumberPosition.getWeight());
        }

        Button button = currentItemView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cellPrice.setText("");
                cellShelfLife.setText("");
                cellFoodName.setText("");
                cellWeight.setText("");
                comeRoom(currentNumberPosition.getId());
            }
        });


        return currentItemView;
    }
    public void comeRoom(int id) {

        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String json = "{\n" +
                            "    \"id\":\"" + id + "\"\n" +
                            "}";

                    RequestBody formBody = RequestBody.create(
                            MediaType.parse("application/json"), json);

                    String string = "http://10.0.2.2:8080/cellToEmpty";
                    Request request = new Request.Builder()
                            .url(string)
                            .addHeader("Authorization", "Bearer " + RestHelper.KEY)
                            .post(formBody)
                            .build();
                    Call call = client.newCall(request);
                    Response response = call.execute();

                    String s = response.body().string();
                    System.out.println("InsideROOm");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        while (thread.isAlive()) {
        }
    }

}
