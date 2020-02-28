package com.company.Notifier;

import com.company.InfoObject.UserInfoObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationFactory {

    public ArrayList<Notifier> getInstance(UserInfoObject userInfoObj){
        ArrayList<Notifier> notifiers = new ArrayList<Notifier> ();

        String notificationType = (String) userInfoObj.getMethod();
//        System.out.println(notificationType);

        List<String> notificationTypes = Arrays.asList(notificationType.split(","));

        for (int i = 0 ; i < notificationTypes.size(); i++) {

            String notifyType = (String)notificationTypes.get(i);
//            System.out.println(notifyType);
            if (notifyType.equals("email")){
                Notifier n = new EmailNotifier(userInfoObj);
                notifiers.add(n);
            }else if (notifyType.equals("sms")){
                Notifier n = new MessageNotifier(userInfoObj);
                notifiers.add(n);
            }


        }

        return notifiers;

    }
}
