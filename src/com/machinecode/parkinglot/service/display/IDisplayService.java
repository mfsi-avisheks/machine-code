package com.machinecode.parkinglot.service.display;

import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.entity.ParkingLot;

public interface IDisplayService {

    public void display(ParkingLot parkingLot, DisplayRequest request);
}
