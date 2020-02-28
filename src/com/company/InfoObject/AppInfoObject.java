package com.company.InfoObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class AppInfoObject implements InfoObject {
        private JSONObject appDetailsObj;

    public AppInfoObject(JSONObject appDetailObj) {
        this.appDetailsObj= appDetailObj;
    }

    public String getPath(){
        final String dir = System.getProperty("user.dir");
//        System.out.println(appDetailsObj);
        String dir_ = (String) appDetailsObj.get("log_file");
//        System.out.println(dir + dir_);
        return dir + dir_;
    }

    public JSONArray getUsers(){
//        System.out.println("users--");

        return (JSONArray) appDetailsObj.get("users");
    }
}
