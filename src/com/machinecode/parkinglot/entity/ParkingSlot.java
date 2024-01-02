package com.machinecode.parkinglot.entity;

import com.machinecode.parkinglot.enums.VehicleType;

public class ParkingSlot {

    private int slotId;
    private String ticket;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSlot() {
    }

    public ParkingSlot(int slotId, String ticket, boolean isOccupied,
        VehicleType vehicleType) {
        this.slotId = slotId;
        this.ticket = ticket;
        this.isOccupied = isOccupied;
        this.vehicleType = vehicleType;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
            ", slotId=" + slotId +
            ", ticket='" + ticket + '\'' +
            ", isOccupied=" + isOccupied +
            ", vehicleType=" + vehicleType +
            ", vehicle=" + vehicle +
            '}';
    }
}
