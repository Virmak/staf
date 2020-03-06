package com.sparkit.staf.runtime.interpreter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class StafConfig {
    public void readConfig(String configFilePath) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(configFilePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
