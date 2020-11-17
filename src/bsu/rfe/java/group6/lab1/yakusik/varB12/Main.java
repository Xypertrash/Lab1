package bsu.rfe.java.group6.lab1.yakusik.varB12;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        boolean isSumCalories = false;
        boolean isSort = false;
        final int variety = 3;
        int[] count = new int[variety];

        int itemsSoFar = 0;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
                count[0]++;
            } else
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
                count[1]++;
            } else
            if (parts[0].equals("Beef")) {
                breakfast[itemsSoFar] = new Beef(parts[1]);
                count[2]++;
            }
            if (parts[0].equals("-calories")) {
                isSumCalories = true;
            } else
                if (parts[0].equals("-sort")) {
                    isSort = true; }
                else itemsSoFar++;
        }
        if(isSort){
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1==null) return 1;
                    if (f2==null) return -1;
                    if (((Food)f1).calculateCalories() > ((Food)f2).calculateCalories()) return 1;
                    else return -1;
                }
            });
        }
        for (Food item: breakfast) {
            if (item != null) {
                item.Consume();
            } else
                break;
        }
        if (isSumCalories){
            double sumOfCalories = 0.0;
            for (Food item: breakfast)
                if (item!=null) {
                    sumOfCalories += item.calculateCalories();
                } else break;
            System.out.println("Калорийность завтрака составляет " + sumOfCalories + " калорий.");
        }
        System.out.println("Употреблено в количестве:");
        System.out.println("Яблоко: " + count[0] + "\nСыр: " + count[1] + "\nBeef: " + count[2]);
        System.out.println("Всего хорошего!");
    }
}