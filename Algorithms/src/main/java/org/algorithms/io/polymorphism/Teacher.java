package org.algorithms.io.polymorphism;

public class Teacher extends Person {
    public Teacher() {
        super();
        System.out.println("Teacher - Constructor");
    }
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        System.out.println("Teacher - calling");
        return super.getName();
    }
}
