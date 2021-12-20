package com.nure.bearer.Helper;

import com.nure.bearer.DTO.Area;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AreaHelper {
    public static String idHeard = "";
    public static String nameHerd = "";
    public static ArrayList<Area> areas;
    Thread thread;
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Area> getAreas() {
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String string =RestHelper.STANDARTWAY+"/user/getallAreas";
                    Request request = new Request.Builder()
                            .url(string)
                            .addHeader("Authorization", "Bearer " + RestHelper.KEY)
                            .get()
                            .build();
                    Call call = client.newCall(request);
                    Response response = call.execute();

                    String s = response.body().string();
                    System.out.println(s);
                    System.out.println("Bearer " + RestHelper.KEY);

                    if (response.code() == 200) {
                        WorkWithJson(s);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        while (thread.isAlive()) {
        }

        return areas;

    }

    public void WorkWithJson(String s) throws JSONException {
        s="{data:"+s+"}";
        s=s.replace("\"result\":true,","");
        JSONObject obj = new JSONObject(s);
        System.out.println(obj.toString());
        JSONArray array = obj.getJSONArray("data");
        areas = new ArrayList<Area>();
        for (int i = 0; i < array.length(); i++) {
            Area area = new Area();
             area.setHeigth(array.getJSONObject(i).getInt("height"));
             area.setWidth(array.getJSONObject(i).getInt("width"));
             area.setId(array.getJSONObject(i).getInt("id"));
            areas.add(area);
        }

    }
}