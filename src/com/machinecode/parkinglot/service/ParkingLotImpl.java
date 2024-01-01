package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.repository.ParkingLotRepository;

public class ParkingLotImpl implements IParkingLot {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    private com.machinecode.parkinglot.entity.ParkingLot parkingLot;
    private DisplayFactory displayFactory = new DisplayFactory();

    @Override
    public void createParkingLot(CreateParkingLotRequest request) {
        this.parkingLot = parkingLotRepository.createParkingLot(request.getLotId(),
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());

        System.out.printf("Created parking lot with %s floors and %s slots per floor%n",
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());
    }

    @Override
    public void display(DisplayRequest request) {
        this.displayFactory.getDisplayService(request.getDisplayType())
            .display(this.parkingLot, request);
    }
}
