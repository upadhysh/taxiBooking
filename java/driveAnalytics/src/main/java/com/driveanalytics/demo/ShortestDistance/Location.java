package com.driveanalytics.demo.ShortestDistance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location implements Comparable<Location>{
    private double x;
    private double y;

    public Location(){}

    public Location(double x, double y){
        setX(x);
        setY(y);
    }

    @Override
    public int compareTo(Location o) {
        if( this.x != o.getX()) return (getX() < o.getX()) ? -1 : 0;
        return (getY() < o.getY()) ? -1 : 0;
    }

    public Location(String data){
        String[] coord = data.split(",");
        for(String s: coord)
            System.out.println(s);
        if(coord.length != 3){
            System.out.println("Invalid data");
            return;
        }
        setX(Double.parseDouble(coord[1]));
        setY(Double.parseDouble(coord[2]));
        System.out.println("here");
    }

    @Override
    public String toString() {
        return getX() + " " + getY();
    }
}