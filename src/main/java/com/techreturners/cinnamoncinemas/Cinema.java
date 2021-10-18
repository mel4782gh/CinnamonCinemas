package com.techreturners.cinnamoncinemas;

import java.util.ArrayList;

public class Cinema {

    private ArrayList seatsAllocated;

    public Cinema() {
        seatsAllocated = new ArrayList();
    }

    public ArrayList getSeatsAllocated() {
        return seatsAllocated;
    }

    public void allocateSeat(Seat seat) {
        seatsAllocated.add(seat);
    }
}
