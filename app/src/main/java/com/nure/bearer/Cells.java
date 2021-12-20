package com.nure.bearer;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nure.bearer.Adapter.Cell;
import com.nure.bearer.Adapter.CellAdapter;
import com.nure.bearer.Adapter.Machine;
import com.nure.bearer.Adapter.MachinsAdapter;
import com.nure.bearer.Helper.RestHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.nure.bearer.Helper.RestHelper.cellList;

public class Cells extends AppCompatActivity {
    private final OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cells);
        final ListView textView = findViewById(R.id.cellListVie);
        ArrayList<Cell> cells = new ArrayList<>();

        CellAdapter cellAdapter = new CellAdapter(this, cellList);
        textView.setAdapter(cellAdapter);

    }
}