package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;

public interface IParkingLot {
    public void createParkingLot(CreateParkingLotRequest createParkingLotRequest);
    public void display(DisplayRequest displayFreeSlotRequest);
}
