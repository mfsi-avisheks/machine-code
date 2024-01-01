package com.machinecode.parkinglot.entity;

import com.machinecode.parkinglot.enums.VehicleType;

public class Vehicle {

    VehicleType vehicleType;
    String registrationNo;
    String color;

    public Vehicle(VehicleType vehicleType, String registrationNo, String color) {
        this.vehicleType = vehicleType;
        this.registrationNo = registrationNo;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "vehicleType=" + vehicleType +
            ", registrationNo='" + registrationNo + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
