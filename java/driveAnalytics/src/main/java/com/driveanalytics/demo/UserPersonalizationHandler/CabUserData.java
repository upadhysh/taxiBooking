package com.driveanalytics.demo.UserPersonalizationHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Repository
@RequestMapping("/api/userInfo")
public class CabUserData implements UserData {

    @Override
    @GetMapping("/dummyUserName")
    public ResponseEntity<String> getLoggedInUserName() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/dummyLocation", produces = "application/json")
    public ResponseEntity<List<String>> getUserLocation(){
        System.out.println(Arrays.asList("112233"));
        return new ResponseEntity<>(Arrays.asList("112233"), HttpStatus.OK);
    }
}
