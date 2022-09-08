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
    private static int errorDetector; //this will be used in loop to check if 
    //the return input is either an incorrect integer or an incorrect string.
    //without this, the program will ask for an extra input if i use in.next() 
    //if i do not include in.next(), there will be an endless loop if user inputs 
    //anything incorrect.
    // 0 = invalid int
    // 1 = invalid string
    // 2 = valid input
    
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
                try{//try catch block
                    System.out.println("Input your car's make: ");
                    //make if else block
                    if(in.hasNext("[A-Za-z]*")){  // if 'in has alphabetical input
                        make = in.next(); // set 'make' to the next string input
                        break; //break loop
                    } else {
                        throw new Exception("Invalid input."); //otherwise throw error
                    } 
                }catch (Exception excpt){
                    System.out.println(excpt.getMessage()); //get error message
                    System.out.println("Please try again.");
                    in.next(); //get the next line
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
                            errorDetector = 0; // input was invalid int
                            throw new Exception("Invalid year.");
                        }
                        else if (year > 2023){ //no cars are further than '2023' model.
                            errorDetector = 0; // input was invalid int
                            throw new Exception("Invalid year.");
                        } else {
                            errorDetector = 2;
                            break;
                        }
                    }
                    else{
                        errorDetector = 1;
                        throw new Exception("Input was not an integer.");
                    }
                
                } catch (Exception excpt){
                    System.out.println(excpt.getMessage());
                    System.out.println("Please try again.");
                    if(errorDetector == 1){
                        in.next();
                    }
                }
                
            }
    
            //loop for mileage input
            while(true){
                try{
                    System.out.println("Input your car's mileage: ");
                    if(in.hasNextInt()){
                        mileage = in.nextInt();
                        if (mileage < 0){ //if the next integer is less than 0
                            errorDetector = 0; //set the errorDetector to 0 for int error
                            throw new Exception("Invalid amount.");
                        } else {
                            //no errors detected, break from loop.
                            errorDetector = 2;
                            break;
                        }
                    } else {
                        errorDetector = 1; // found that the input was not a string.
                        throw new Exception("Input was not an integer.");
                    }
                    } catch (Exception excpt){
                        System.out.println(excpt.getMessage());
                        System.out.println("Please try again.");
                        if(errorDetector == 1){
                            in.next();
                        }
                        
    
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
        while(true){
            try{
                System.out.println("Input the capacity of your inventory: ");
                if(in.hasNextInt()){ // if the next input is an int
                    capacity = in.nextInt(); //set capacity to next int
                    if (capacity <= 0){ //if capacity is <= 0, 
                        errorDetector = 0; // set error detector to 0 for int
                        throw new Exception("Invalid amount."); //throw invalid input error
                    } else {
                        break;// otherwise, break out of loop
                    }
                } else {
                    errorDetector = 1; //otherwise, it is not an integer
                    throw new Exception("Input was not an integer.");
                    
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

    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    public static int menuOptions(int menuChoice){
        

        do{
            System.out.println("Main Menu");
            System.out.println("1.) Add a vehicle ");
            System.out.println("2.) Remove a vehicle.");
            System.out.println("3.) List all Vehicles.");
            System.out.println("4.) Update a Vehicle.");
            System.out.println("5.) Exit");
            System.out.println("Please select your Menu Choice: ");
            

            try{

                if(in.hasNextInt()){
                    menuChoice = in.nextInt();
                    switch(menuChoice){
                
                        case 1: //case for adding a vehicle
                            addVehicle(make, model, color, year, mileage); // this will create a new vehicle
                            clearScreen();
                            break;
    
                        case 2: //case for removing a vehicle
                            System.out.println("This section has not been added yet!"); //TODO
                            break;
    
                        case 3: //case for Listing all vehicles
                            listVehicleInfo(); //this will list the vehicle information
                            break;
    
                        case 4: //case for updating a vehicle
                            System.out.println("This section has not been added yet!"); //TODO
                            break;
    
                        case 5: //case for exiting a program.
                            System.out.println("Exiting program."); //TODO
                            System.exit(3);
                            break;
    
                        default: 
                            throw new Exception("Not a valid Menu Option. Please try again!");
    
                    }

                } else {
                    errorDetector = 1;
                    throw new Exception("Input was not a number. Please try again!");

                }
                
            } catch(Exception excpt) {
                System.out.println(excpt.getMessage());
                if (errorDetector ==1){
                    in.next();
                }
                
            }


        }while(menuChoice != 5);

        return menuChoice;

    }

    public static void main(String[] args){
        System.out.println("Hi! We are going to store your vehicle information in your inventory.");
        System.out.println("First, we will set the capacity of your inventory.");
        setCapacity(); //this will have the user set the capacity of the vehicle inventory.
        menuOptions(0);
    }
    
}
