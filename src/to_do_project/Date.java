
package to_do_project;

public class Date implements Comparable<Date> { 
    private int day;
    private int year;
    private int month;
    private String date;

    public Date() {}

    public Date(int day, int year, int month) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDate() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    
    @Override
    public int compareTo(Date Date2) {
        if (this.year != Date2.year) {
            return this.year - Date2.year;
        }
        if (this.month != Date2.month) {
            return this.month - Date2.month;
        }
        return this.day - Date2.day;
    }
}
