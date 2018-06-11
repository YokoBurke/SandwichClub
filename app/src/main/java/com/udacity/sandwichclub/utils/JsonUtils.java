package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    static final String THIS_CLASS = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {

        String mainName = "";
        List<String> AKAList = new ArrayList<String>();
        List<String> ingredientList = new ArrayList<String>();
        String placeOfOrigin = "";
        String description = "";
        String image = "";

        try {

            JSONObject baseJsonResponse = new JSONObject(json);
            JSONObject name = baseJsonResponse.getJSONObject("name");

            mainName = name.getString("mainName");
            JSONArray AKAArray = name.getJSONArray("alsoKnownAs");

            for (int i = 0; i < AKAArray.length(); i++) {

                String currentAKAArray = AKAArray.getString(i);
                AKAList.add(currentAKAArray);

            }

            placeOfOrigin = baseJsonResponse.getString("placeOfOrigin");
            Log.i(THIS_CLASS, placeOfOrigin + "DESU!!");
            description = baseJsonResponse.getString("description");
            image = baseJsonResponse.getString("image");

            JSONArray ingredientsArray = baseJsonResponse.getJSONArray("ingredients");

            for (int i = 0; i < ingredientsArray.length(); i++) {

                String currentIngredients = ingredientsArray.getString(i);
                ingredientList.add(currentIngredients);

            }


        } catch (JSONException e) {
            Log.e(THIS_CLASS, "Problem parsing the Sandwich JSON results", e);
        }

        Log.i(THIS_CLASS, mainName + " " + placeOfOrigin + " " + description);
        Sandwich mySandwich = new Sandwich(mainName, AKAList, placeOfOrigin, description, image, ingredientList);

        return mySandwich;
    }
}
