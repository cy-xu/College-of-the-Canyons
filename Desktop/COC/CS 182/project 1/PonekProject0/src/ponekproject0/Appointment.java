package ponekproject0;
/*
Kevin Ponek
Appointment.java
March 8, 2016
CS 182 Lab Project 1
Description: This is the Appointment class that is the blueprint to create an object that tracks important
    dates.  It will track the month, day hour, minute, and message.  It controls the values that these variables
    are set to in order to make all data correct.
*/
import java.util.Scanner;

public class Appointment {
    private int day, hour, minute;
    private String month, message;
    
    public static void main(String[] args){
        Appointment obj1 = new Appointment();
        obj1.inputAppointment();
        System.out.println("Object 1: " + obj1.toString());
        Appointment obj2 = new Appointment("Dec",31,12,30,"Here is the message");
        System.out.println("Object 2: " + obj2.toString());
    }
    //constructors
    public Appointment(){
        setMonth("Jan");
        setDay(1);
        setHour(0);
        setMinute(0);
        setMessage("None");
    }
    public Appointment(String mo, int da, int ho, int mi, String me){
        setMonth(mo);
        setDay(da);
        setHour(ho);
        setMinute(mi);
        setMessage(me);
    }
    //get and set methods
    public int getDay(){
        return day;
    }
    public void setDay(int d){
        if (d >= 1 && d <= 31) day = d;
        else System.out.println("Invalid day value: " + d);
    }
    public int getHour(){
        return hour;
    }
    public void setHour(int h){
        if (h >= 0 && h <= 24) hour = h;
        else System.out.println("Invalid hour value: " + h);
    }
    public int getMinute(){
        return minute;
    }
    public void setMinute(int m){
        if (m >= 0 && m <= 59) minute = m;
        else System.out.println("Invalid minute value: " + m);
    }
    public String getMonth(){
        return month;
    }
    public void setMonth(String m){
        String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        boolean invalidVal = true;//boolean to track if the parameter is a 3 character month or not
        for (int i = 0; i < months.length; i++){
            if (m.toUpperCase().equals(months[i])){
                month = m;
                invalidVal = false;
                break;
            }
        }
        if (invalidVal == true) System.out.println("Invalid month value: " + m);
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String m){
        if (m.length() <= 40) message = m;
        else System.out.println("Invalid message length: " + m.length());
    }
    //toString method with format to print Appointments
    public String toString(){
        //convert hour and minute to string with leading 0 if single digit
        String h,m;
        if (getHour() < 10){
            h = "0" + getHour();
        }
        else h = "" + getHour();
        if (getMinute() < 10){
            m = "0" + getMinute();
        }
        else m = "" + getMinute();
        
        return getMonth() + " " + getDay() + ", " + h + ":"
                + m + " - " + getMessage();
    }
    //uses UserInput.java to control data in
    public void inputAppointment(){
        System.out.println("Please input month (3 letter), day (1 - 31), hour (0 - 24), minute (0 - 59), and message (max 40 letters");
        setMonth(UserInput.getString(3,3));
        setDay(UserInput.getInt(1,31));
        setHour(UserInput.getInt(0,24));
        setMinute(UserInput.getInt(0,59));
        setMessage(UserInput.getString(0,40));
        
    }
}

