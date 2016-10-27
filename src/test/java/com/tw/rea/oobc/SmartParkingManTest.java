package com.tw.rea.oobc;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmartParkingManTest {
    private ParkingMan smartParkingMan;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ParkingLot parkingLot3;
    private Car car;
    private ParkingStrategy parkingStrategy;

    @Before
    public void setUp() throws Exception {
        parkingLot1 = new ParkingLot(1);
        parkingLot2 = new ParkingLot(2);
        parkingLot3 = new ParkingLot(3);
        car = new Car();
        parkingStrategy = new MostAvailableParkingStrategy();
        smartParkingMan = new ParkingMan(asList(parkingLot1, parkingLot2, parkingLot3), parkingStrategy);
    }

    @Test
    public void shouldParkCarInLotWhichHasMoreSpaces() throws Exception {
        smartParkingMan.park(new Car());
        smartParkingMan.park(new Car());

        smartParkingMan.park(car);
        assertThat(parkingLot3.isCarParked(car), is(true));
    }
}
