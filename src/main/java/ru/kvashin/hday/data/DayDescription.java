package ru.kvashin.hday.data;

public class DayDescription {

    private final String date;
    private final String mainHolidayDescription;
    private final String link;
    private final String img;

    public DayDescription(String date, String mainHolidayDescription, String link, String img) {
        this.date = date;
        this.mainHolidayDescription = mainHolidayDescription;
        this.link = link;
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public String getMainHolidayDescription() {
        return mainHolidayDescription;
    }

    public String getLink() {
        return link;
    }

    public String getImg() {
        return img;
    }
}
