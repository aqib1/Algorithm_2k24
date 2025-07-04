package org.algorithms.io.copy;

import java.util.ArrayList;
import java.util.List;

public final class Car {
    private String name;
    private List<String> colors;

    public Car(String name, List<String> colors) {
        this.name = name;
        this.colors = colors;
    }

    public List<String> getColors() {
        return new ArrayList<>(colors);
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Car(name, new ArrayList<>(colors));
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colors=" + colors +
                '}';
    }

    public static void main(String[] args) {
        var colors = new ArrayList<>(List.of("red", "blue"));
        var car = new Car("BMW", new ArrayList<>(colors));
        System.out.println(car);
        colors.add("black");
        System.out.println(car);
        car.getColors().add("black");
        System.out.println(car);
    }
}
