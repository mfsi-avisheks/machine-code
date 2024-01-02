package com.machinecode.parkinglot.service;

import com.machinecode.parkinglot.enums.DisplayType;
import com.machinecode.parkinglot.service.display.IDisplayService;
import com.machinecode.parkinglot.service.display.impl.FreeCountDisplayServiceImpl;
import com.machinecode.parkinglot.service.display.impl.FreeSlotDisplayServiceImpl;
import com.machinecode.parkinglot.service.display.impl.OccupiedSlotDisplayServiceImpl;

public class DisplayFactory {

    public IDisplayService getDisplayService(DisplayType displayType) {
        switch (displayType) {
            case FREE_COUNT:
                return new FreeCountDisplayServiceImpl();
            case FREE_SLOTS:
                return new FreeSlotDisplayServiceImpl();
            case OCCUPIED_SLOTS:
                return new OccupiedSlotDisplayServiceImpl();
            default:
                throw new IllegalArgumentException("Invalid display type: " + displayType);
        }
    }
}
