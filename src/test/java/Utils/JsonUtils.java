package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonUtils {

    public String getValueForGivenKey(String jsonStr, String key) {
        JSONObject json = new JSONObject(jsonStr);
        return json.get(key).toString();
    }

    public String getValueFromJsonArrayForGivenKey(String jsonStr, String jsonArray, String key) {
        JSONObject json = new JSONObject(jsonStr);
        JSONArray partJson = new JSONArray(json.get(jsonArray).toString());
        JSONObject firstArray = (JSONObject) partJson.get(0);
        return firstArray.get(key).toString();
    }
}
