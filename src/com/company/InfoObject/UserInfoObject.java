package com.company.InfoObject;

import org.json.simple.JSONObject;

public class UserInfoObject implements InfoObject {
    JSONObject userDetailObj;

    public UserInfoObject(JSONObject userDetailObj) {

        this.userDetailObj = userDetailObj;
    }

    public String getMethod(){
        return (String) userDetailObj.get("notificationTypes");
    }

    public String getName()
    {
        return (String) userDetailObj.get("name");
    }

    public String getEmail()
    {
        return (String) userDetailObj.get("email");
    }

    public String getPhone()
    {
        return (String) userDetailObj.get("phone");
    }
}
