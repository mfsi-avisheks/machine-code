package com.machinecode.parkinglot.entity;

import java.util.List;

public class ParkingLot {

    private String lotId;
    private int noOfFloors;
    private int noOfSlotsPerFloor;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot(String lotId, int noOfFloors, int noOfSlotsPerFloor,
        List<ParkingFloor> parkingFloorList) {
        this.lotId = lotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.parkingFloorList = parkingFloorList;
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

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    @Override
    public String toString() {
        return "IParkingLot{" +
            "lotId='" + lotId + '\'' +
            ", noOfFloors=" + noOfFloors +
            ", noOfSlotsPerFloor=" + noOfSlotsPerFloor +
            ", parkingFloorList=" + parkingFloorList +
            '}';
    }
}
