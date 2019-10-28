package com.driveanalytics.demo.ShortestDistance;

import com.driveanalytics.demo.ResourceLoader.DataReader;
import com.driveanalytics.demo.UserPersonalizationHandler.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.LinkedList;

@Service
@RequestMapping("/cabInfo")
public class DistanceEvaluator {

    @Autowired
    @Qualifier(value = "cabUserData")
    UserData userData;

    @Autowired
    DataReader dataReader;

    List<Location> allLocations = new ArrayList<>();

    public void getUserLocation(){
        System.out.println(userData.getLoggedInUserName());
        System.out.println(userData.getUserLocation());
    }

    /**
     * Get closest 5 drivers.
     *
     * @param myLocation
     * @return
     */
    @GetMapping("/closestDrivers/{myLocation}")
    ResponseEntity<List<Location>> getClosestLocatip(@PathVariable String myLocation){
        List<Location> closestLocations = new LinkedList<>();
        System.out.println(myLocation);
        Location pos = new Location(myLocation);
        System.out.println(pos);
        List<Location> locationlListToConsider = getLocationListFor(pos);
        System.out.println("*");
        for(Location s: locationlListToConsider)
            System.out.println(s.toString());
        System.out.println("**");
        Integer index = Collections.binarySearch(locationlListToConsider, pos);
        for( Integer i = Math.max(0,index-2); i<= Math.min(locationlListToConsider.size()-1, index+2);i++)
            closestLocations.add(locationlListToConsider.get(i));
        System.out.println(closestLocations);
        return new ResponseEntity<>(closestLocations, HttpStatus.OK);
    }


    /**
     * In-case we might want to index all locations and then narrow down to the list of locations closest to our customer.
     * Indexing can be done on a country based or simply coordinate list based method.
     *
     * For now we are just using the dummy list.
     * @param myLocation
     * @return
     */
    private List<Location> getLocationListFor(Location myLocation) {
        return allLocations;
    }

    // initialise list once Bean is created created
    @PostConstruct
    private void mountList(){
        try{
            dataReader.changeDataSource("/Users/rooh/taxiBooking/java/driveAnalytics/data/cities.csv");
            System.out.println("here");
//            allLocations.add(new Location(dataReader.readData()));
            String loc;
            Integer number = 0;
            while((loc=dataReader.readData())!=null){
                allLocations.add(new Location(loc));
                number++;
                if(number == 100)
                    break;
            }
//            System.out.println(allLocations);
        }
        catch(Exception e){
            System.out.println("Could not initialise file");
            System.out.println(e.getMessage()+ " " + e.getStackTrace());
        }
    }
}
