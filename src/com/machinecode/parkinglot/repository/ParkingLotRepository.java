package com.machinecode.parkinglot.repository;

import com.machinecode.parkinglot.entity.ParkingFloor;
import com.machinecode.parkinglot.entity.ParkingLot;
import com.machinecode.parkinglot.entity.ParkingSlot;
import com.machinecode.parkinglot.enums.VehicleType;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {

    private ParkingLot parkingLot;

    public ParkingLot createParkingLot(String lotId, int noOfFloors, int noOfSlotsPerFloor) {

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int floor=1; floor<=noOfFloors; floor++) {
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            String ticket = String.format("%s_%s_%s", lotId, floor, 1);
            parkingSlots.add(new ParkingSlot(1, ticket, false, VehicleType.TRUCK));

            for(int slot=2; slot<=3; slot++) {
                ticket = String.format("%s_%s_%s", lotId, floor, slot);
                parkingSlots.add(new ParkingSlot(slot, ticket, false, VehicleType.BIKE));
            }

            for(int slot=4; slot<=noOfSlotsPerFloor; slot++) {
                ticket = String.format("%s_%s_%s", lotId, floor, slot);
                parkingSlots.add(new ParkingSlot(slot, ticket, false, VehicleType.CAR));
            }

            parkingFloors.add(new ParkingFloor(floor, parkingSlots));
        }

        return new ParkingLot(lotId, noOfFloors, noOfSlotsPerFloor, parkingFloors);
    }
}
