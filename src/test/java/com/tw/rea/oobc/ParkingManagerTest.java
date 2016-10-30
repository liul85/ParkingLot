package com.tw.rea.oobc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingManagerTest {
    private ParkingLot parkingLot;
    private ParkingLot parkingLot2;
    private ParkingStrategy parkingStrategy;
    private ParkingManager parkingManager;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(2);
        parkingLot2 = new ParkingLot(4);
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot2);

        parkingStrategy = new HighVacancyRateParkingStrategy();

        parkingManager = new ParkingManager(parkingLots, parkingStrategy);
    }

    @Test
    public void managerShouldParkInLotWithHighFreeRate() throws Exception {
        parkingLot2.park(new Car());
        Car car = new Car();
        parkingManager.park(car);
        assertThat(parkingLot.isCarParked(car), is(true));
    }
}
