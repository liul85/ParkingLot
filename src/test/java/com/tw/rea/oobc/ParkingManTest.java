package com.tw.rea.oobc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingManTest {
    private ParkingLot parkingLot;
    private ParkingLot parkingLot2;
    private Car car;
    private ParkingMan parkingMan;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1);
        parkingLot2 = new ParkingLot(1);
        List<ParkingLot> lots = new ArrayList<>();
        lots.add(parkingLot);
        lots.add(parkingLot2);

        car = new Car();
        car2 = new Car();
        parkingMan = new ParkingMan(lots);
    }

    @Test
    public void parkingManCanParkCar() throws Exception {
        parkingMan.park(car2);
        assertThat(parkingMan.park(car), is(true));
    }

    @Test
    public void parkingManCanNotParkCarWhenLotsFull() throws Exception {
        Car car3 = new Car();
        parkingMan.park(car);
        parkingMan.park(car2);

        assertThat(parkingMan.park(car3), is(false));
    }

    @Test
    public void parkingManCanFetchCar() throws Exception {
        parkingMan.park(car);
        parkingMan.park(car2);
        assertThat(parkingMan.fetch(car2), is(car2));
    }

    @Test
    public void parkingManShouldFetchCarFailedIfNotParked() throws Exception {
        parkingMan.park(car2);
        Car fetchedCar = parkingMan.fetch(car);
        assertThat(fetchedCar, is(nullValue()));
    }
}
