package org.example.utils.functions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jsonHandler {


    public static JSONObject jsonManager (String path) throws ParseException, IOException {
        //parser
        //object

        System.out.println(path);
        JSONParser parser = new JSONParser();

        JSONObject data = (JSONObject) parser.parse(new FileReader(path));

        return data;
    }
}
