import java.util.Scanner;

public class Main {
    private static String make;
    private static String model;
    private static String color;
    private static int year;
    private static int mileage;
    static Scanner in = new Scanner(System.in);
    static int capacity;
    Automobile[] carArray = new Automobile[capacity];
    static void defaultConstructor(){

    }

    


    static void listVehicleInfo(){
        new Automobile(make, model, color, year, mileage);

        System.out.println("Here is what you input. ");
        System.out.println("Make: " + Automobile.make);
        System.out.println("Model: " + Automobile.model);
        System.out.println("Year: " + Automobile.year);
        System.out.println("Color: " + Automobile.color);
        System.out.println("Mileage: " + Automobile.mileage);

    }
    
    public static String addVehicle(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage){
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
                        if (year < 1885){ //1885 was the year cars were first made
                            throw new Exception("Invalid input.");
                        }
                        else if (year > 2023){
                            throw new Exception("Invalid input.");
                        } else {
                            break;
                        }
                    }
                    else{
                        throw new Exception("Invalid input.");
                    }
                
                } catch (Exception excpt){
                    System.out.println(excpt.getMessage());
                    System.out.println("Please try again.");
                }
                
            }
    
            //loop for mileage input
            while(true){
                try{
                    System.out.println("Input your car's mileage: ");
                    if(in.hasNextInt()){
                        mileage = in.nextInt();
                        if (mileage < 0){ 
                            throw new Exception("Invalid input.");
                        } else {
                            break;
                        }
                    } else {
                        throw new Exception("Invalid input.");
                        
                    }
                    
                    } catch (Exception excpt){
                        System.out.println(excpt.getMessage());
                        System.out.println("Please try again.");
                        in.next();
    
                }
            }
        return "success";
    }

    static String removeVehicle(String autoMake, String autoModel, String autoColor, int autoYear){
        return "success";

    }

    static void updateVehicleAttributes(){

    }

    public static int setCapacity(){
        int errorDetector = 0; //this will be used in the loop to check if the return input is an integer or not
        //without this, the program will ask for an extra input if i use in.next() 
        //in the catch when user inputs a capacity <=0, and then it will loop back.
        //if i do not include in.next(), there will be an endless loop if user inputs anything except an int.
        while(true){
            try{
                System.out.println("Input the capacity of your inventory: ");
                if(in.hasNextInt()){ // if the next input is an int
                    capacity = in.nextInt(); //set capacity to next int
                    if (capacity <= 0){ //if capacity is <= 0, 
                        errorDetector = 0; // set error detector to 0 for int
                        throw new Exception("Invalid input."); //throw invalid input error
                    } else {
                        break;// otherwise, break out of loop
                    }
                } else {
                    errorDetector = 1; //otherwise, it is not an integer
                    throw new Exception("Invalid input.");
                    
                }
                } catch (Exception excpt){
                    System.out.println(excpt.getMessage()); //get error message
                    System.out.println("Please try again.");
                    if(errorDetector == 1){ //if errorDetector is 1, it is not an integer, therefore get next line
                        in.next();
                    }
                    

            }
        }
        return capacity;
    }

    public static void main(String[] args){
        System.out.println("Hi! We are going to store your vehicle information in your inventory.");
        setCapacity(); //this will set the capacity of the vehicle inventory.
        addVehicle(make, model, color, year, mileage); // this will create a new vehicle
        listVehicleInfo(); //this will list the vehicle information
    }
    
}
