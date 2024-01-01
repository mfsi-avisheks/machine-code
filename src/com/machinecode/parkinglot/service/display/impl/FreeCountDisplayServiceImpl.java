package com.machinecode.parkinglot.service.display.impl;

import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.entity.ParkingLot;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.service.display.IDisplayService;
import java.util.stream.Collectors;

public class FreeCountDisplayServiceImpl implements IDisplayService {

    @Override
    public void display(ParkingLot parkingLot, DisplayRequest request) {
        parkingLot.getParkingFloorList()
            .forEach(parkingFloor -> {
                Long freeSlotsCount = parkingFloor.getParkingSlotList().stream()
                    .filter(slot -> !slot.isOccupied() && slot.getVehicleType()
                        .equals(request.getVehicleType()))
                    .collect(Collectors.counting());
                System.out.printf("No. of free slots for %s on Floor %d: %d%n", request.getVehicleType(),
                    parkingFloor.getFloorId(), freeSlotsCount);
            });
    }
}
