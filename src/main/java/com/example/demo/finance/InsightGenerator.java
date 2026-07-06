package com.example.demo.finance;   
public class InsightGenerator {

    public void generate(double smart, double normal, double yolo) {

        System.out.println("\n--- INSIGHTS ---");

        if (smart > normal && smart > yolo) {
            System.out.println("Smart lifestyle gives the highest returns.");
        }

        if (yolo < normal) {
            double loss = normal - yolo;
            System.out.println("YOLO lifestyle costs you: " + loss);
        }

        if (smart > yolo) {
            double difference = smart - yolo;
            System.out.println("Difference between Smart and YOLO: " + difference);
        }

        if (normal == smart) {
            System.out.println("Your habits are already efficient.");
        }

        if (smart == 0 && normal == 0 && yolo == 0) {
            System.out.println("You're not saving anything. Increase income or reduce expenses.");
        }
    }
}
