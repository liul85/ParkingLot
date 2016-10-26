package com.tw.rea.oobc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingMan {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingMan(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public boolean park(Car car) {
        Optional<ParkingLot> availableLot = findAvailableLot(parkingLots);
        if (availableLot.isPresent()) {
            availableLot.get().park(car);
            return true;
        }
        return false;
    }

    private Optional<ParkingLot> findAvailableLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst();
    }

    public Car fetch(Car car) {
        Optional<ParkingLot> lot = parkingLots.stream().filter(parkingLot -> parkingLot.isCarParked(car)).findFirst();
        if (lot.isPresent()) {
            return lot.get().fetch(car);
        }
        return null;
    }
}
