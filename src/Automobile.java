import java.util.Scanner;

public class Automobile {
    public static String make;
    public static String model;
    public static String color;
    public static int year;
    public static int mileage;
    static Scanner in = new Scanner(System.in);

    //parameterized constructor for automobile object
    public Automobile(String autoMake, String autoName, String autoColor, int autoYear, int autoMileage ){
        make = autoMake;
        model = autoName;
        color = autoColor;
        year = autoYear;
        mileage = autoMileage;

    }

            

}

    

