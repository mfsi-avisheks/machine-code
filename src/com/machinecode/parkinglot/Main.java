package com.machinecode.parkinglot;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.dto.ParkVehicleRequest;
import com.machinecode.parkinglot.dto.UnParkVehicleRequest;
import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.enums.VehicleType;
import com.machinecode.parkinglot.service.ParkingLotImpl;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println(scanner.next());
//            if(scanner.next().equalsIgnoreCase("exit")) return;
//        }

        ParkingLotImpl parkingLot = new ParkingLotImpl();
        parkingLot.createParkingLot(new CreateParkingLotRequest("PR1234", 2, 6));

        parkingLot.display(new DisplayRequest(DisplayType.of("free_count"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_count"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_count"), VehicleType.CAR));

        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.CAR));

        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.CAR));

        parkingLot.parkVehicle(new ParkVehicleRequest(VehicleType.TRUCK, "WB-45-HO-9030", "RED"));
        parkingLot.parkVehicle(new ParkVehicleRequest(VehicleType.TRUCK, "WB-45-HO-9031", "RED"));
        parkingLot.parkVehicle(new ParkVehicleRequest(VehicleType.TRUCK, "WB-45-HO-9032", "RED"));

        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.CAR));

        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.CAR));

        parkingLot.unParkVehicle(new UnParkVehicleRequest("PR1234_1_1"));
        parkingLot.unParkVehicle(new UnParkVehicleRequest("PR1234_2_1"));
        parkingLot.parkVehicle(new ParkVehicleRequest(VehicleType.TRUCK, "WB-45-HO-9031", "RED"));

        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.CAR));

        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.TRUCK));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.BIKE));
        parkingLot.display(new DisplayRequest(DisplayType.of("occupied_slots"), VehicleType.CAR));

    }

}
