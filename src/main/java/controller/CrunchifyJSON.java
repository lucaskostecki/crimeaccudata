package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrunchifyJSON {

    public String arrayListToJSON(ArrayList list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();

        return gson.toJson(list);
    }

    public String listToJSON(List list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();

        return gson.toJson(list);
    }

    public String mapToJson(Map map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();

        return gson.toJson(map);
    }
}