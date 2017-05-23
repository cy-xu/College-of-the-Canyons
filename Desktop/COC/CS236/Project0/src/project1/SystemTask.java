import java.util.Scanner;

public class SystemTask extends UserInput {
    
    private String month;
    private int day;
    private int hour;
    private int minute;
    private String message;
    
    public String getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public String getMessage() {
        return message;
    }
    public void setMonth(String m) {
        String validMonths[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        for (int i = 0; i < validMonths.length; i++) {
            if (m.equals(validMonths[i])) {
                month = m;
            }
        }
    }
    public void setDay(int d) {
        if (d >= 0 && d <= 31)
            day = d;
    }
    public void setHour(int h) {
        if (h >= 0 && h <= 24)
            hour = h;
    }
    public void setMinute(int m) {
        if (m >= 0 && m <= 60)
            minute = m;
    }
    public void setMessage(String m) {
        if (m.length() <= 40)
            message = m;
    }
    public SystemTask(){
        month = "Jan";
        day = 1;
        hour = 12;
        minute = 0;
        message = "Happy New Year!";
    }
    public SystemTask(String m, int d, int h, int mi, String me){
        setMonth(m);
        setDay(d);
        setHour(h);
        setMinute(mi);
        setMessage(me);
    }
    public String toString() {
        String hourString;
        String minuteString;
        
        if (hour < 10) {
            hourString = "0" + Integer.toString(hour);
        }
        else
            hourString = Integer.toString(hour);
        if (minute < 10) {
            minuteString = "0" + Integer.toString(minute);
        }
        else
            minuteString = Integer.toString(minute);
        return (month + " " + day + ", " + hourString + ":" + minuteString + " " + message);
    }
    public void inputSystemTask() {
        System.out.println("Please enter the first three characters of the month");
        this.setMonth(getString(3,3));
        System.out.println("Please enter the day as a number");
        this.setDay(getInt(0,31));
        System.out.println("Please enter the hour");
        this.setHour(getInt(0,24));
        System.out.println("Please enter the minute");
        this.setDay(getInt(0,60));
        System.out.println("Please enter a message");
        this.setMessage(getString(0,40));
    }
    public void main() {
        SystemTask obj1 = new SystemTask();
        inputSystemTask();
        obj1.toString();
        
        SystemTask obj2 = new SystemTask("Sep",15,8,0,"Project 1 Due");
        obj2.toString();
        UserInput.getChar('k','p');
    }
}
