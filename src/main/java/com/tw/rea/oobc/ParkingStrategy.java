package com.tw.rea.oobc;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots);
}
