package com.tw.rea.oobc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingMan {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private ParkingStrategy parkingStrategy;

    public ParkingMan(List<ParkingLot> parkingLots, ParkingStrategy parkingStrategy) {
        this.parkingLots = parkingLots;
        this.parkingStrategy = parkingStrategy;
    }

    public boolean park(Car car) {
        Optional<ParkingLot> availableLot = parkingStrategy.findParkingLot(parkingLots);
        if (availableLot.isPresent()) {
            availableLot.get().park(car);
            return true;
        }
        return false;
    }

    public Car fetch(Car car) {
        Optional<ParkingLot> lot = parkingLots.stream().filter(parkingLot -> parkingLot.isCarParked(car)).findFirst();
        if (lot.isPresent()) {
            return lot.get().fetch(car);
        }
        return null;
    }
}
