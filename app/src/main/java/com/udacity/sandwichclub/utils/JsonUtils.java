package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private static ArrayList<String> convertJsonArrayToList(JSONArray list) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list.length(); i++) {
            arrayList.add(list.getString(i));
        }
        return arrayList;
    }

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");

            String mainName = nameObject.getString("mainName");
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> aliases = convertJsonArrayToList(alsoKnownAs);

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientList = convertJsonArrayToList(ingredients);

            Sandwich sandwich = new Sandwich(mainName, aliases, placeOfOrigin, description, image, ingredientList);
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
