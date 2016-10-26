package com.tw.rea.oobc;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<Car> parkedCars = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Car car) {
        if (parkedCars.size() < capacity) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    public Car fetch(Car car) {
        if (parkedCars.contains(car)) {
            return car;
        }
        return null;
    }
}
