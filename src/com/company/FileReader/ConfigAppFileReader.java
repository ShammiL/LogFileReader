package com.company.FileReader;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class ConfigAppFileReader implements AppFileReader {

    private String path;
    public ConfigAppFileReader(String path) {
        this.path=path;
    }
    @Override
    public Object read() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);



            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        ;
        return  null;
    }
}
