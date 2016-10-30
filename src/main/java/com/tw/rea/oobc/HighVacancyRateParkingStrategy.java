package com.tw.rea.oobc;

import java.util.List;
import java.util.Optional;

public class HighVacancyRateParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingLot> findParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().max((p1, p2) -> p2.getVacancyRate() - p1.getVacancyRate());
    }
}
