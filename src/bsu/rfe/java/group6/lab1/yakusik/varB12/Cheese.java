package bsu.rfe.java.group6.lab1.yakusik.varB12;

public class Cheese extends Food{
	public Cheese() {
        super("Сыр");
    }
    public void Consume() {
        System.out.println(this + " eaten");
    }
    public double calculateCalories() {
        return 300.0;
    }

}
