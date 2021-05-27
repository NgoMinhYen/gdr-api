package dataObject;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Country {
    public String readFileJsonAndGetCountryCode(String countryName){
        String countryCode=null;
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("src\\test\\resources\\data\\country.json");
            Object obj = jsonParser.parse(reader);
            JSONObject empjsonobj = (JSONObject) obj;
            JSONArray array =(JSONArray) empjsonobj.get("data");

            for (int i=0; i<array.size();i++){
                JSONObject data = (JSONObject) array.get(i);
                if (data.get("country").equals(countryName)){
                    countryCode = (String) data.get("postCode");
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return countryCode;
    }

    public String readFileJsonAndGetCountryName(String countryCode){
        String countryName = null;
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("src\\test\\resources\\data\\country.json");
            Object obj = jsonParser.parse(reader);
            JSONObject empjsonobj = (JSONObject) obj;
            JSONArray array =(JSONArray) empjsonobj.get("data");

            for (int i=0; i<array.size();i++){
                JSONObject data = (JSONObject) array.get(i);
                if (data.get("postCode").equals(countryCode)){
                    countryName = (String) data.get("country");
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return countryName;
    }
}
