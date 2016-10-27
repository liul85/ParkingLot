package com.tw.rea.oobc;

import java.util.List;
import java.util.Optional;

public class MostAvailableParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((o1, o2) -> o1.getAvailableSpace() - o2.getAvailableSpace());
    }
}
