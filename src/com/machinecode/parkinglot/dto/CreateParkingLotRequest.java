package com.machinecode.parkinglot.dto;

public class CreateParkingLotRequest {

    private String lotId;
    private int noOfFloors;
    private int noOfSlotsPerFloor;

    public CreateParkingLotRequest(String lotId, int noOfFloors, int noOfSlotsPerFloor) {
        this.lotId = lotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }
}
