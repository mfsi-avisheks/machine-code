package com.machinecode.parkinglot.dto;

import com.machinecode.parkinglot.enums.VehicleType;

public class UnParkVehicleRequest {
    private String ticket;

    public UnParkVehicleRequest(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }
}
