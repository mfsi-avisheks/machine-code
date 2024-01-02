package com.machinecode.parkinglot;

import com.machinecode.parkinglot.dto.CreateParkingLotRequest;
import com.machinecode.parkinglot.dto.DisplayRequest;
import com.machinecode.parkinglot.dto.ParkVehicleRequest;
import com.machinecode.parkinglot.dto.UnParkVehicleRequest;
import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.enums.VehicleType;
import com.machinecode.parkinglot.service.ParkingLotImpl;
import com.machinecode.parkinglot.utils.CommandUtils;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotImpl parkingLot = new ParkingLotImpl();

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            switch (CommandUtils.of(command[0])) {
                case CREATE_PARKING_LOT:
                    parkingLot.createParkingLot(new CreateParkingLotRequest(command[1],
                        Integer.parseInt(command[2]),
                        Integer.parseInt(command[3])));
                    break;
                case PARK_VEHICLE:
                    parkingLot.parkVehicle(
                        new ParkVehicleRequest(VehicleType.valueOf(command[1]), command[2],
                            command[3]));
                    break;
                case UNPARK_VEHICLE:
                    parkingLot.unParkVehicle(new UnParkVehicleRequest(command[1]));
                    break;
                case DISPLAY:
                    parkingLot.display(new DisplayRequest(DisplayType.of(command[1]),
                        VehicleType.valueOf(command[2])));
                    break;
                case EXIT:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
