package ponekproject0;
/*
Kevin Ponekl
l
Planner.java
March 8, 2016
CS 182 Lab Project 1
Description: This is the Planner class that creates a list of Appointment objects to
organize important days in sorted order.  It gives the user control to insert, delete, 
and compare appointment days.
*/

import java.util.Scanner;

public class Planner {
    private Appointment[] planner = new Appointment[20];
    
    public static void main(String[] args){
       Planner myPlanner = new Planner();
       myPlanner.run();
        
    }
    public Planner(){//done
        Appointment quiz1 = new Appointment("Mar",4,17,30,"Quiz 1");
        Appointment midterm = new Appointment("Apr",1,17,30,"Midterm");
        Appointment quiz2 = new Appointment("May",6,17,30,"Quiz 2");
        Appointment finalExam = new Appointment("Jun",3,17,30,"Final");
        planner[0] = quiz1;
        planner[1] = midterm;
        planner[2] = quiz2;
        planner[3] = finalExam;
    }
    public void run(){//done
        while (true){
            System.out.println("A)dd Appointment , D)elete Appointment , L)ist Appointment , E)xit");
            char charInput = UserInput.getChar('A','Z');
            if (Character.toUpperCase(charInput) == 'A') addAppointment();
            else if (Character.toUpperCase(charInput) == 'D') deleteAppointment();
            else if (Character.toUpperCase(charInput) == 'L') listAppointment();
            else if (Character.toUpperCase(charInput) == 'E') break;
         }
    }
    //compare appointments, and returns true if A1 < A2
    public boolean compareAppointment(Appointment A1, Appointment A2){//done
        //compare months
        String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        int a1MonthNum = -1;
        int a2MonthNum = -1;
        for (int i = 0; i < months.length; i++){
            if (A1.getMonth().toUpperCase().equals(months[i]))
                a1MonthNum = i;
            if (A2.getMonth().toUpperCase().equals(months[i]))
                a2MonthNum = i;
        }
        if (a1MonthNum > a2MonthNum)
            return false;
        else if (a1MonthNum == a2MonthNum){
            //compare day
            if (A1.getDay() > A2.getDay())
                return false;
            else if (A1.getDay() == A2.getDay()){
                //compare hours
                if (A1.getHour() > A2.getHour())
                     return false;
                else if (A1.getHour() == A2.getHour()){
                    //compare minutes
                    if (A1.getMinute() > A2.getMinute())
                        return false;
                }
            }
        }
        //A1 <= A2
        return true;
    }
    public void insertAppointment(Appointment A1){//done
        //loop to find the index that A1 should be placed at
        int index = planner.length - 1;//default index is at the end
        for (int i = 0; i < planner.length; i++){
            if (planner[i] == null) { // to avoid NullPointerException when inserting to last slot before null values
                index = i;
                break;
            }
            if (compareAppointment(planner[i],A1) == false)
            {
                index = i;
                break;
            }
        }
        //shift over data after index to the right
        for (int i = planner.length-1; i > index; i--){
            planner[i] = planner[i-1];
        }
        //insert the appointment A1 into the index
        planner[index] = A1;
    }
    public void listAppointment(){//done
        for (int i = 1; i < planner.length + 1; i++){
            if (planner[i-1] != null) //does not list empty slots in planner[]
                System.out.println(i + ") " + planner[i - 1]);
        }
    }
    public void deleteAppointment(){//done
      System.out.println("Which appointment number to delete?");
      int appNum = UserInput.getInt(1,planner.length);
      planner[appNum - 1] = null;//deletes the object
      for (int i = appNum; i < planner.length; i++){//shift over the array to the left
          planner[i - 1] = planner[i];
      }
    }
    public void addAppointment(){//done
        Appointment newApp = new Appointment();
        newApp.inputAppointment();
        insertAppointment(newApp);
    }
}
