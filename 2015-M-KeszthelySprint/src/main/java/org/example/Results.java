package org.example;

import java.time.LocalTime;
import java.util.Locale;

public class Results {

    public String name;
    public int birthYear;
    public int startNumber;
    public String sex;
    public String category;
    public LocalTime swimmingTime;
    public LocalTime firstDepoTime;
    public LocalTime cyclingTime;
    public LocalTime secondDepoTime;
    public LocalTime runningTime;

    public Results(String dataLine) {
        String[] Data = dataLine.split(";");
        this.name = Data[0];
        this.birthYear = Integer.parseInt(Data[1]);
        this.startNumber = Integer.parseInt(Data[2]);
        this.sex = Data[3];
        this.category = Data[4];
        this.swimmingTime = LocalTime.parse(Data[5]);
        this.firstDepoTime = LocalTime.parse(Data[6]);
        this.cyclingTime = LocalTime.parse(Data[7]);
        this.secondDepoTime = LocalTime.parse(Data[8]);
        this.runningTime = LocalTime.parse(Data[9]);
    }

    @Override
    public String toString() {
        return name +
                ";" + birthYear +
                ";" + startNumber +
                ";" + sex +
                ";" + category +
                ";" + swimmingTime +
                ";" + firstDepoTime +
                ";" + cyclingTime +
                ";" + secondDepoTime +
                ";" + runningTime +"\n";
    }
}
