package com.tw.rea.oobc;

import java.util.List;
import java.util.Optional;

public class NormalParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst();
    }
}
