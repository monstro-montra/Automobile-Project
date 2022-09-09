import java.util.Scanner;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    Scanner in = new Scanner(System.in);


    //parameterized constructor for automobile object
    public Automobile(String autoMake, String autoName, String autoColor, int autoYear, int autoMileage ){
        make = autoMake;
        model = autoName;
        color = autoColor;
        year = autoYear;
        mileage = autoMileage;

    }

    //setters
    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMileage(int mileage){
        this.mileage = mileage;
    }

    //getters
    public String getMake(String make){
        return this.make;
    }

    public String getModel(String model){
        return this.model;
    }

    public String getColor(String color){
        return this.color;
    }

    public int getYear(int year){
        return this.year;
    }

    public int getMileage(int mileage){
        return this.mileage;  
    }





    public void showData(){
        System.out.print("Make: " + getMake(make) + "\n");
        System.out.print("Model: " + getModel(model) + "\n");
        System.out.print("Color: " + getColor(color) + "\n");
        System.out.print("Year: " + getYear(year) + "\n");
        System.out.print("Mileage: " + getMileage(mileage) + "\n");
    }

            

}

    

