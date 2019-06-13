package ru.kvashin.hday.data;

public class DayDescription {

    private final String date;
    private final String mainHolydayDescription;

    public DayDescription(String date, String mainHolydayDescription) {
        this.date = date;
        this.mainHolydayDescription = mainHolydayDescription;
    }

    public String getDate() {
        return date;
    }

    public String getMainHolydayDescription() {
        return mainHolydayDescription;
    }
}
