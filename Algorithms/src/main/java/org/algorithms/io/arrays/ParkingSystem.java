package org.algorithms.io.arrays;

class ParkingSystem {
    private final int[] parkingSlots;
    public ParkingSystem(int big, int medium, int small) {
        this.parkingSlots = new int[3];
        parkingSlots[0] = big;
        parkingSlots[1] = medium;
        parkingSlots[2] = small;
    }


    public boolean addCar(int carType) {
        int parkingIndex = carType == 1 ? 0 : carType == 2 ? 1 : 2;
        if(parkingSlots[parkingIndex] == 0) return false;

        parkingSlots[parkingIndex]--;

        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
