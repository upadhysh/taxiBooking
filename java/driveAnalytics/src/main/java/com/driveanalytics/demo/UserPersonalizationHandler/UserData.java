package com.driveanalytics.demo.UserPersonalizationHandler;

import org.springframework.http.ResponseEntity;

import java.util.List;


//@Controller
public interface UserData {

    ResponseEntity<String> getLoggedInUserName();

    ResponseEntity<List<String>> getUserLocation();
}
