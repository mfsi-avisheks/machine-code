package com.machinecode.parkinglot;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
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

        parkingLot.display(new DisplayRequest(DisplayType.of("free_slots"), VehicleType.CAR));
    }

}
