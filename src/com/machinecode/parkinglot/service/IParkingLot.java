package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.dto.ParkVehicleRequest;
import com.machinecode.parkinglot.dto.UnParkVehicleRequest;

public interface IParkingLot {

    public void createParkingLot(CreateParkingLotRequest createParkingLotRequest);

    public void display(DisplayRequest displayFreeSlotRequest);

    public void parkVehicle(ParkVehicleRequest parkVehicleRequest);

    public void unParkVehicle(UnParkVehicleRequest displayFreeSlotRequest);
}
