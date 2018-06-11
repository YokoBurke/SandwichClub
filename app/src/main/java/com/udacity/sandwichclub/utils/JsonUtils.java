package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    static final String THIS_CLASS = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {

        Sandwich mySandwich;

            try {

                JSONObject baseJsonResponse = new JSONObject(json);
                JSONObject name = baseJsonResponse.getJSONObject("name");

                String mainName = name.getString("mainName");
                List alsoKnownAs = name.getString()


            } catch (JSONException e) {
                Log.e(THIS_CLASS, "Problem parsing the earthquake JSON results", e);
            }


        return null;
    }
}
