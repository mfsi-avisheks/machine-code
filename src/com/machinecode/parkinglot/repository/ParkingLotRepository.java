package com.machinecode.parkinglot.repository;

import com.machinecode.parkinglot.dto.ParkVehicleRequest;
import com.machinecode.parkinglot.dto.UnParkVehicleRequest;
import com.machinecode.parkinglot.entity.ParkingFloor;
import com.machinecode.parkinglot.entity.ParkingLot;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.entity.Vehicle;
import com.machinecode.parkinglot.enums.VehicleType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotRepository {

    private ParkingLot parkingLot = new ParkingLot();

    public ParkingLot createParkingLot(String lotId, int noOfFloors, int noOfSlotsPerFloor) {

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for (int floor = 1; floor <= noOfFloors; floor++) {
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            String ticket = String.format("%s_%s_%s", lotId, floor, 1);
            parkingSlots.add(new ParkingSlot(1, ticket, false, VehicleType.TRUCK));

            for (int slot = 2; slot <= 3; slot++) {
                ticket = String.format("%s_%s_%s", lotId, floor, slot);
                parkingSlots.add(new ParkingSlot(slot, ticket, false, VehicleType.BIKE));
            }

            for (int slot = 4; slot <= noOfSlotsPerFloor; slot++) {
                ticket = String.format("%s_%s_%s", lotId, floor, slot);
                parkingSlots.add(new ParkingSlot(slot, ticket, false, VehicleType.CAR));
            }

            parkingFloors.add(new ParkingFloor(floor, parkingSlots));
        }

        //return new ParkingLot(lotId, noOfFloors, noOfSlotsPerFloor, parkingFloors);
        parkingLot.setLotId(lotId);
        parkingLot.setNoOfFloors(noOfFloors);
        parkingLot.setNoOfSlotsPerFloor(noOfSlotsPerFloor);
        parkingLot.setParkingFloorList(parkingFloors);

        return this.parkingLot;
    }

    public Optional<ParkingSlot> findFirstAvailableSlot(ParkVehicleRequest parkVehicleRequest) {

        Vehicle vehicle = new Vehicle(parkVehicleRequest.getVehicleType(),
            parkVehicleRequest.getRegistrationNo(), parkVehicleRequest.getColor());

        return parkingLot.getParkingFloorList()
            .stream()
            .flatMap(parkingFloor -> parkingFloor.getParkingSlotList().stream())
            .filter(parkingSlot -> !parkingSlot.isOccupied() && parkingSlot.getVehicleType()
                .equals(parkVehicleRequest.getVehicleType()))
            .findFirst()
            .map(parkingSlot -> {
                parkingSlot.setOccupied(true);
                parkingSlot.setVehicle(vehicle);
                return parkingSlot;
            });
    }

    public Optional<Vehicle> findAndUnParkVehicle(UnParkVehicleRequest unParkVehicleRequest) {

        return parkingLot.getParkingFloorList()
            .stream()
            .flatMap(parkingFloor -> parkingFloor.getParkingSlotList().stream())
            .filter(parkingSlot -> parkingSlot.getTicket()
                .equals(unParkVehicleRequest.getTicket()))
            .findFirst()
            .map(parkingSlot -> {
                Vehicle vehicle = parkingSlot.getVehicle();

                parkingSlot.setOccupied(false);
                parkingSlot.setVehicle(null);

                return vehicle;
            });
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
