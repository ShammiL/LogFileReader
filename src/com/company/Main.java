package com.company;

import com.company.FileReader.AppFileReader;
import com.company.FileReader.ConfigAppFileReader;
import com.company.FileReader.LogAppFileReader;
import com.company.InfoObject.AppInfoObject;
import com.company.InfoObject.InfoObject;
import com.company.InfoObject.UserInfoObject;
import com.company.LineCounter.AllLineCounter;
import com.company.LineCounter.ErrorLineCounter;
import com.company.Notifier.NotificationFactory;
import com.company.Notifier.Notifier;
import com.company.ObjectCreater.AppInfoObjectCreater;
import com.company.ObjectCreater.ObjectCreater;
import com.company.ObjectCreater.UserInfoObjectCreater;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AppFileReader fileReader = new ConfigAppFileReader("E:\\zone_assignments\\logFileReader\\src\\com\\company\\config.json");
        Object appDetailsListObj = fileReader.read();
//        System.out.println(appDetailsListObj);
        ObjectCreater objCrt = new AppInfoObjectCreater(appDetailsListObj);
        ArrayList<InfoObject> AppInfoList =  objCrt.createObject();

        for (InfoObject i:AppInfoList){
            AppInfoObject appInfo = (AppInfoObject) i;
            String logLocation = appInfo.getPath();
//            System.out.println(logLocation);
            JSONArray usersInfoObj = appInfo.getUsers();
            ObjectCreater userInfoObjCrt = new UserInfoObjectCreater(usersInfoObj);
            ArrayList<InfoObject> UserInfoList = userInfoObjCrt.createObject();
//            System.out.println(UserInfoList);

            AppFileReader logReader = new LogAppFileReader(logLocation);

            Object logFileObj = logReader.read();
            int count = new ErrorLineCounter(logFileObj).count();
//            System.out.println(count);

            for (int c=0 ; c < count; c++){
//                System.out.println(c);
                for (InfoObject u: UserInfoList ){
                    UserInfoObject usr = (UserInfoObject) u;
//                    System.out.println(usr.getName());
                    NotificationFactory ntfFac = new NotificationFactory();
                    ArrayList<Notifier> notifiers = ntfFac.getInstance((UserInfoObject) u);
//                    System.out.println(notifiers);
                    for (Notifier n: notifiers){
                        n.notifyUsers();
//                        System.out.println(n);
                    }
                }

            }
        }
    }
}

//soonarlint