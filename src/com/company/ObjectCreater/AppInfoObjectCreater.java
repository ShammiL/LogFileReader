package com.company.ObjectCreater;

import com.company.InfoObject.AppInfoObject;
import com.company.InfoObject.InfoObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class AppInfoObjectCreater implements ObjectCreater {
        Object appDetailsListObj;
        ArrayList<InfoObject> AppInfoList = new ArrayList<>();

    public AppInfoObjectCreater(Object appDetailsListObj) {
            this.appDetailsListObj = appDetailsListObj;
        }

        @Override
        public ArrayList<InfoObject> createObject() {
            JSONArray appDetails = (JSONArray) appDetailsListObj;

            for (int i = 0 ; i < appDetails.size(); i++) {
                InfoObject infoObj = new AppInfoObject((JSONObject) appDetails.get(i));
                AppInfoList.add(infoObj);
            }
            return AppInfoList;
        }
    }

