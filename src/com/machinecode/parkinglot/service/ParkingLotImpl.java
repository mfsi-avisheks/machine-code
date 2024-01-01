package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.repository.ParkingLotRepository;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ParkingLotImpl implements IParkingLot {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    private com.machinecode.parkinglot.entity.ParkingLot parkingLot;

    @Override
    public void createParkingLot(CreateParkingLotRequest request) {
        this.parkingLot = parkingLotRepository.createParkingLot(request.getLotId(),
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());

        System.out.printf("Created parking lot with %s floors and %s slots per floor%n",
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());
    }

    @Override
    public void display(DisplayRequest request) {
        parkingLot.getParkingFloorList()
            .forEach(parkingFloor -> {
                String freeSlots = parkingFloor.getParkingSlotList().stream()
                    .filter(slot -> !slot.isOccupied() && slot.getVehicleType()
                        .equals(request.getVehicleType()))
                    .map(ParkingSlot::getSlotId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
                System.out.printf("Free slots for %s on Floor %d: %s%n", request.getVehicleType(),
                    parkingFloor.getFloorId(), freeSlots);
            });
    }
}
