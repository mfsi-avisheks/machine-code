package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.dto.ParkVehicleRequest;
import com.machinecode.parkinglot.dto.UnParkVehicleRequest;
import com.machinecode.parkinglot.entity.ParkingLot;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.repository.ParkingLotRepository;
import java.util.Optional;

public class ParkingLotImpl implements IParkingLot {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    private com.machinecode.parkinglot.entity.ParkingLot parkingLot;
    private DisplayFactory displayFactory = new DisplayFactory();

    @Override
    public void createParkingLot(CreateParkingLotRequest request) {
        ParkingLot parkingLot = parkingLotRepository.createParkingLot(request.getLotId(),
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());

        System.out.printf("Created parking lot with %s floors and %s slots per floor%n",
            request.getNoOfFloors(), request.getNoOfSlotsPerFloor());
    }

    @Override
    public void display(DisplayRequest request) {
        this.displayFactory.getDisplayService(request.getDisplayType())
            .display(this.parkingLotRepository.getParkingLot(), request);
    }

    @Override
    public void parkVehicle(ParkVehicleRequest parkVehicleRequest) {
        this.findFirstAvailableSlot(parkVehicleRequest);
    }

    private void findFirstAvailableSlot(ParkVehicleRequest parkVehicleRequest) {
        Optional<ParkingSlot> parkingSlot = parkingLotRepository.findFirstAvailableSlot(
            parkVehicleRequest);

        if (parkingSlot.isPresent()) {
            ParkingSlot slot = parkingSlot.get();
            System.out.printf("Parked vehicle. Ticket ID: %s%n",  slot.getTicket());
        } else {
            System.out.printf("No available slots for the specified vehicle type.%n");
        }
    }

    @Override
    public void unParkVehicle(UnParkVehicleRequest displayFreeSlotRequest) {

    }
}
