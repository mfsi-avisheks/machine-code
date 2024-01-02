package com.machinecode.parkinglot.utils;

import java.util.HashMap;

public enum CommandUtils {

    CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    EXIT("exit");

    private final String command;

    CommandUtils(String s) {
        command = s;
    }

    public String toString() {
        return this.command;
    }

    private static final HashMap<String, CommandUtils> map = new HashMap<>(values().length, 1);

    static {
        for (CommandUtils c : values()) {
            map.put(c.command, c);
        }
    }

    public static CommandUtils of(String name) {
        return map.get(name);
    }


}
