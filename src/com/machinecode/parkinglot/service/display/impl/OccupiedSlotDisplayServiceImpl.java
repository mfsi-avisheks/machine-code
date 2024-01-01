package com.machinecode.parkinglot.service.display.impl;

import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.entity.ParkingLot;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.service.display.IDisplayService;
import java.util.stream.Collectors;

public class OccupiedSlotDisplayServiceImpl implements IDisplayService {

    @Override
    public void display(ParkingLot parkingLot, DisplayRequest request) {
        parkingLot.getParkingFloorList()
            .forEach(parkingFloor -> {
                String freeSlots = parkingFloor.getParkingSlotList().stream()
                    .filter(slot -> slot.isOccupied() && slot.getVehicleType()
                        .equals(request.getVehicleType()))
                    .map(ParkingSlot::getSlotId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
                System.out.printf("Occupied slots for %s on Floor %d: %s%n", request.getVehicleType(),
                    parkingFloor.getFloorId(), freeSlots);
            });
    }
}
