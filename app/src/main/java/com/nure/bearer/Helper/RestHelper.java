package com.nure.bearer.Helper;


import com.nure.bearer.Adapter.Cell;

import java.util.ArrayList;
import java.util.List;

public class RestHelper {
    public static String KEY = "";

    public static String STANDARTWAY = "http://10.0.2.2:8080";
    public  static  int idIot;
    public static boolean canInside = false;
    public static String NAME = "";
    public static String EMAIL = "";
    public static boolean isUkr = false;
    public static ArrayList<Cell> cellList;

    public static void clean() {
        KEY = "";
        NAME = "";
        EMAIL = "";
        canInside = false;
    }


}


