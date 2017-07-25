package suttonsLog.domain.model;

/**
 * Created by leens on 8/13/2016.
 */
public class BlogDate {
    private String day;
    private String month;
    private String year;
    private String time;

    public BlogDate(){}

    public BlogDate(String day,
                    String month,
                    String year,
                    String time) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;
    }

    public String getDateString(){
        return this.day + " " + this.month +  " " + this.year + " " + this.time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
