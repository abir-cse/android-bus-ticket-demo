package com.ngicon.busticker;

public class BusItems {
    private String bus_name;
    private String dep_time;
    private String  seat_available;
    private String fare;
    public BusItems() {}

    public BusItems(String bus_name, String dep_time, String seat_available, String fare) {
        this.bus_name = bus_name;
        this.dep_time = dep_time;
        this.seat_available = seat_available;
        this.fare = fare;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getSeat_available() {
        return seat_available;
    }

    public void setSeat_available(String seat_available) {
        this.seat_available = seat_available;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }


}
