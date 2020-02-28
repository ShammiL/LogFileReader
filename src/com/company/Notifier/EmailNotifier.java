package com.company.Notifier;

import com.company.InfoObject.UserInfoObject;

public class EmailNotifier implements Notifier {
    private UserInfoObject userInfoObj;

    public EmailNotifier(UserInfoObject userInfoObj) {
        this.userInfoObj = userInfoObj;
    }

    @Override
    public void notifyUsers() {
        System.out.println(userInfoObj.getName() + ", ERROR messsage sent to " + userInfoObj.getEmail());

    }
}
