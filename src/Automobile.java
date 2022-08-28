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
        //loop for make input
        while(true){
            try{
                System.out.println("Input your car's make: ");
                //make if else block
                if(in.hasNext("[A-Za-z]*")){
                    make = in.next();
                    break;
                } else {
                    throw new Exception("Invalid input.");
                } 
            }catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
        }
        
        //loop for model input
        while(true){
            try{
                System.out.println("Input your car's model: ");
                if(in.hasNext("[A-Za-z]*")){
                    model = in.next();
                    break;
                } else if(in.hasNext("[A-Za-z]*" + "[0123456789]")){ // or if the next input contains numbers and alphabet
                    model = in.next();
                    break;
                } else {
                    throw new Exception("Invalid input.");
                } 
            }catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
        }

        //loop for color input
        while(true){
            try{
                System.out.println("Input your car's color: ");
                //make if else block
                if(in.hasNext("[A-Za-z]*")){
                    color = in.next();
                    break;
                } else {
                    throw new Exception("Invalid input.");
                } 
            }catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
        }

        //loop for year input
        while(true){
            try{
                System.out.println("Input your car's year: ");
                if(in.hasNextInt()){
                    year = in.nextInt();
                    break;
                }
                else if(year < 1885){ // the year they created cars
                    throw new Exception("Invalid input.");
                }
                else if(year > 2023){
                    throw new Exception("Invalid input.");
                }
                else{
                    throw new Exception("Invalid input.");
                }
            
            } catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
            
        }

        //loop for mileage input
        while(true){
            try{
                System.out.println("Input your car's mileage: ");
                if(in.hasNextInt()){
                    mileage = in.nextInt();
                    break;
                } else if(mileage < 0){
                    throw new Exception("Invalid input.");
                }
                else{
                    throw new Exception("Invalid input.");
                }
            }catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
            
        }
    }

}

    

