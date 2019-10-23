package com.driveanalytics.demo;

import com.driveanalytics.demo.ShortestDistance.DistanceEvaluator;
import com.driveanalytics.demo.UserPersonalizationHandler.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.driveanalytics.demo.UserPersonalizationHandler")
public class StartUpApplication {

    @Autowired
    @Qualifier(value = "cabUserData")
    static UserData userData;

    @Autowired
    static DistanceEvaluator de;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StartUpApplication.class, args);
        System.out.println("up and running!!!!");
        System.out.println("Contains cabUserData  " + context.containsBeanDefinition("cabUserData"));
        System.out.println("Contains A  " + context.containsBeanDefinition("userData"));
//        System.out.println(userData.getLoggedInUserName());
//        de.getUserLocation();
    }

}
