package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Results> results = new ArrayList<>();

            //1.feladat

            try (BufferedReader reader = new BufferedReader(new FileReader("Eredmenyek.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Results results1 = new Results(line);
                    results.add(results1);
                }
            }

            //2. feladat

            System.out.println("2. feladat: A versenyt " + results.size() + " versenyző fejezte be.");

            //3. feladat

            int elitJunior = 0;
            for (Results result : results) {
                if (result.category.equals("elit junior")) {
                    elitJunior++;
                }
            }
            System.out.println("3. feladadt: A versenyzők száma az \"elit junior\" kategóriában: " + elitJunior + " fő.");

            //4. feladat

            float averageAge = 0;
            for (Results results1 : results) {
                averageAge += 2014 - results1.birthYear;
            }
            averageAge /= results.size();
            System.out.printf("4. feladat: Átlagéletkor: %.1f év.\n" ,averageAge);

            //5. feladat

            System.out.print("5. feladat: Kérek egy kategóriát: ");
            Scanner scanner = new Scanner(System.in);
            String kategory = scanner.nextLine();
            System.out.print("Rajtszám(ok):");
            int counter = 0;
            for (Results result : results) {
                if (result.category.equals(kategory)) {
                    System.out.print(" " + result.startNumber);
                    counter++;
                }
            }
            if (counter == 0) {
                System.out.print(" Nincs ilyen kategória!");
            }
            System.out.println();

            //6. feladat

            String winner = null;
            int bestTime = Integer.MAX_VALUE;
            for (Results result : results) {
                int actualTime;
                if (result.sex.equals("f") ){
                    continue;
                }
                actualTime =
                    result.swimmingTime.toSecondOfDay() +
                    result.firstDepoTime.toSecondOfDay() +
                    result.cyclingTime.toSecondOfDay() +
                    result.secondDepoTime.toSecondOfDay() +
                    result.runningTime.toSecondOfDay();

                /*actualTime =
                    result.swimmingTime.getSecond() +
                    result.swimmingTime.getMinute() * 60 +
                    result.swimmingTime.getHour() * 60 * 60 +
                    result.firstDepoTime.getSecond() +
                    result.firstDepoTime.getMinute() * 60 +
                    result.firstDepoTime.getHour() * 60 * 60 +
                    result.cyclingTime.getSecond() +
                    result.cyclingTime.getMinute() * 60 +
                    result.cyclingTime.getHour() * 60 * 60 +
                    result.secondDepoTime.getSecond() +
                    result.secondDepoTime.getMinute() * 60 +
                    result.secondDepoTime.getHour() * 60 * 60 +
                    result.runningTime.getSecond() +
                    result.runningTime.getMinute() * 60 +
                    result.runningTime.getHour() * 60 * 60;*/

                /*for (int i = 0; i < 5; i++) {
                    String[] data = new String[3];
                    switch (i) {
                        case 0:
                            data = result.swimmingTime.toString().split(":");
                            break;
                        case 1:
                            data = result.firstDepoTime.toString().split(":");
                            break;
                        case 2:
                            data = result.cyclingTime.toString().split(":");
                            break;
                        case 3:
                            data = result.secondDepoTime.toString().split(":");
                            break;
                        case 4:
                            data = result.runningTime.toString().split(":");
                            break;
                    };
                    actualTime +=
                        Integer.parseInt(data[0]) * 60 * 60 +
                        Integer.parseInt(data[1]) * 60 +
                        Integer.parseInt(data[2]);
                }*/

                    if (actualTime < bestTime) {
                        bestTime = actualTime;
                        winner = result.name;
                    }
            }
            System.out.println("6. feladaat: A legjobb időt " + winner + " érte el.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

