package com.machinecode.parkinglot.dto;

public class UnParkVehicleRequest {

    private String ticket;

    public UnParkVehicleRequest(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return ticket;
    }
}
