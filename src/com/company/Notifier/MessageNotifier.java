package com.company.Notifier;

import com.company.InfoObject.UserInfoObject;

public class MessageNotifier implements Notifier {
    private UserInfoObject userInfoObj;

    public MessageNotifier(UserInfoObject userInfoObj) {

        this.userInfoObj = userInfoObj;
    }

    @Override
    public void notifyUsers() {
        System.out.println(userInfoObj.getName() + ", ERROR messsage sent to " + userInfoObj.getPhone());
    }
}
