package com.driveanalytics.demo.ShortestDistance;

import com.driveanalytics.demo.UserPersonalizationHandler.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DistanceEvaluator {

    @Autowired
    @Qualifier(value = "cabUserData")
    UserData userData;

    public void getUserLocation(){
        System.out.println(userData.getLoggedInUserName());
        System.out.println(userData.getUserLocation());
    }
}
