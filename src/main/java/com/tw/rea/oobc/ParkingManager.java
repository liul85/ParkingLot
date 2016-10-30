package com.tw.rea.oobc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingManager extends ParkingMan {
    private List<ParkingMan> parkingMen = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLots, ParkingStrategy parkingStrategy) {
        super(parkingLots, parkingStrategy);
    }



    public boolean assignToPark(Car car) {
        Optional<ParkingMan> parkingManOpt = parkingMen.stream().filter(ParkingMan::canPark).findFirst();
        if (parkingManOpt.isPresent()) {
            return parkingManOpt.get().park(car);
        }

        return false;
    }

    public void addParkingMan(ParkingMan parkingMan) {
        parkingMen.add(parkingMan);
    }
}
