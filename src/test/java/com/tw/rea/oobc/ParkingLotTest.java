package com.tw.rea.oobc;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private Car car;
    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1);
        car = new Car();
    }

    @Test
    public void shouldParkCarWhenLotIsNotFull() throws Exception {
        assertThat(parkingLot.park(car), is(true));
    }

    @Test
    public void shouldFetchCorrectCarWhenItsParked() throws Exception {
        parkingLot.park(car);
        assertThat(parkingLot.fetch(car), is(car));
    }

    @Test
    public void shouldFetchCarFailedWhenItsNotParked() throws Exception {
        assertThat(parkingLot.fetch(car), is(nullValue()));
    }

    @Test
    public void shouldParkFailedWhenLotIsFull() throws Exception {
        parkingLot.park(car);
        Car newcar = new Car();

        assertThat(parkingLot.park(newcar), is(false));
    }
}
