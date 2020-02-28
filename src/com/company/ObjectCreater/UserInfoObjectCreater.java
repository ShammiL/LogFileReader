package com.company.ObjectCreater;

import com.company.InfoObject.AppInfoObject;
import com.company.InfoObject.InfoObject;
import com.company.InfoObject.UserInfoObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class UserInfoObjectCreater implements ObjectCreater {
    JSONArray usersInfoObj;
    ArrayList<InfoObject> UserInfoList = new ArrayList<>();

    public UserInfoObjectCreater(JSONArray usersInfoObj)
    {
        this.usersInfoObj = usersInfoObj;
    }

    @Override
    public ArrayList<InfoObject> createObject() {
        for (int i = 0 ; i < usersInfoObj.size(); i++) {
            InfoObject UserinfoObj = new UserInfoObject((JSONObject) usersInfoObj.get(i));
            UserInfoList.add(UserinfoObj);
        }
        return UserInfoList;
    }
}
