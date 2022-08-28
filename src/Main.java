import java.util.Scanner;

public class Main {
    private static String make;
    private static String model;
    private static String color;
    private static int year;
    private static int mileage;
    static Scanner in = new Scanner(System.in);

    static void defaultConstructor(){

    }

    static void listVehicleInfo(){
        new Automobile(make, model, color, year, mileage);

        System.out.println("Here is what you input. ");
        System.out.println("Make: " + Automobile.make);
        System.out.println("Model: " + Automobile.model);
        System.out.println("Color: " + Automobile.color);
        System.out.println("Year: " + Automobile.year);
        System.out.println("Mileage: " + Automobile.mileage);
        
    }
    
    public String addVehicle(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage){
        return "success";
    }

    static String removeVehicle(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage){
        return "success";

    }

    static void updateVehicleAttributes(){

    }

    public static void main(String[] agrs){

        listVehicleInfo();

    }
    
}
