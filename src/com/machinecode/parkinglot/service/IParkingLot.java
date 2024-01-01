package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.entity.ParkingLot;

public interface IParkingLot {
    public void createParkingLot(CreateParkingLotRequest createParkingLotRequest);
    public void display(DisplayRequest displayFreeSlotRequest);
}
