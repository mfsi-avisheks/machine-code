package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.enums.DisplayType;
import java.util.Set;

public class DisplayFactory {
    private Set<IDisplayService> displayServices;

    public IDisplayService getDisplayService(DisplayType displayType) {
        switch (displayType) {
//            case "free_count":
//                return new FreeCountDisplay();
            case FREE_SLOTS:
                return new FreeSlotDisplayService();
//            case "occupied_slots":
//                return new OccupiedSlotsDisplay();
            default:
                throw new IllegalArgumentException("Invalid display type: " + displayType);
        }
    }
}
