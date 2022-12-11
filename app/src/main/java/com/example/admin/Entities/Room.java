package com.example.admin.Entities;

public class Room {
    private String number;
    private String floor;
    private String state;

    public Room() {
    }

    public Room(String number, String floor, String state) {
        this.number = number;
        this.floor = floor;
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
