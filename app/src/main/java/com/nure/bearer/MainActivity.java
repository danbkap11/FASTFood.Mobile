package com.nure.bearer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nure.bearer.Helper.RestHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText loginText;
    private EditText passText;
    private TextView errorText;
    private Button logButton;
    private static String errorMessage = "логин ошибка";
    private static String txt = "";
    private final OkHttpClient client = new OkHttpClient();
    public static Thread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Resources res = this.getResources();
        RestHelper.clean();


        errorMessage = res.getString(R.string.err_conn);
        loginText = findViewById(R.id.editTextTextEmailAddress);
        passText = findViewById(R.id.editTextTextPassword);
        logButton = findViewById(R.id.buttonLogin);
        errorText = findViewById(R.id.textERROR);

        loginText.setText("login");
        passText.setText("pass");
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginText.getText().toString().isEmpty()) {
                    errorText.setText(res.getString(R.string.loginAsLagin));
                    return;
                }
                whenSendPostRequest_thenCorrect(loginText.getText().toString(), passText.getText().toString());
                while (thread.isAlive()) {

                }
                if (RestHelper.canInside) {
                    errorText.setText("");
                    Intent intent = new Intent(MainActivity.this, Machins.class);
                    startActivity(intent);
                    RestHelper.canInside = false;

                } else {
                    errorText.setText(txt);
                }
            }
        });


    }

    public void whenSendPostRequest_thenCorrect(String login, String pass) {
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String json = "{\n" +
                            "    \"login\":\"" + login + "\",\n" +
                            "    \"password\":\"" + pass + "\"\n" +
                            "}";

                    RequestBody formBody = RequestBody.create(
                            MediaType.parse("application/json"), json);
                    String string = "http://10.0.2.2:8080/login";
                    Request request = new Request.Builder()
                            .url(string)
                            .post(formBody)
                            .build();

                    Call call = client.newCall(request);
                    Response response = call.execute();
                    String string1 = response.body().string();


                    if ((int) response.code() / 100 == 2) {
                        String stringBuilder = string1;

                        RestHelper.KEY = WorkWithJson(stringBuilder);
                        System.out.println(RestHelper.KEY);
                        RestHelper.EMAIL = login;
                        RestHelper.canInside = true;
                    } else {
                        txt = errorMessage;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    public String WorkWithJson(String s) throws JSONException {
        JSONObject obj = new JSONObject(s);
        return (obj.getString("token"));
    }
}