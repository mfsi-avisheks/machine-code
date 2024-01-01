package com.machinecode.parkinglot.dto;

import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.enums.VehicleType;

public class DisplayRequest {
    private DisplayType displayType;
    private VehicleType vehicleType;

    public DisplayRequest(DisplayType displayType, VehicleType vehicleType) {
        this.displayType = displayType;
        this.vehicleType = vehicleType;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
