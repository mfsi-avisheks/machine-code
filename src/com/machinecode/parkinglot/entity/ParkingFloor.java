package com.machinecode.parkinglot.entity;

import java.util.List;

public class ParkingFloor {

    private int floorId;
    private List<ParkingSlot> parkingSlotList;

    public ParkingFloor(int floorId, List<ParkingSlot> parkingSlotList) {
        this.floorId = floorId;
        this.parkingSlotList = parkingSlotList;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
