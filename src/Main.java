import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static String make;
    static String model;
    static String color;
    static int year;
    static int mileage;
    static int capacity;
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Automobile> carList = new ArrayList<Automobile>(capacity);

    
    static void listAllVehicleInfo(){
        System.out.println("AUTOMOBILE LIST: \n");
        for(int i = 0; i < carList.size(); i++){
            System.out.println("Automobile: " + (i+1));
            System.out.println(carList.get(i) + "\n" + "\n");
        }
        if(carList.size() < 1){
            System.out.println("There aren't any vehicles at the moment!");
        }
    }
    
    public static ArrayList<Automobile> addVehicle(Automobile automobile){ //DONE
        int howMany;
        System.out.println("How many vehicles would you like to add?");
        while(true){
            try{
                if(in.hasNextInt()){
                    howMany = in.nextInt();
                    if(howMany < 0){
                        throw new IntException("Input is less than 0!"); //throw integer exception 
                    }
                    else{
                        for(int i = 0; i < howMany; i ++){
                            System.out.println("Input car " + (i+1) +" make: ");
                            make = makeInput(make);
                            System.out.println("Input car " + (i+1) + " model: ");
                            model = modelInput(model);
                            System.out.println("Input car " + (i+1) + " color: ");
                            color = colorInput(color);
                            System.out.println("Input car " + (i+1) +" year: ");
                            year = yearInput(year);
                            System.out.println("Input car " + (i+1) + " mileage: ");
                            mileage = mileageInput(mileage);
                            carList.add(new Automobile(make, model, color, year, mileage));    
                        }
                        break;
                    }
                }
                else{
                    throw new InputMismatchException("Input is not an integer!");
                }
                
            } catch (IntException excpt){
                System.out.println(excpt.getException());
                System.out.println("Please try again.");
            } catch (InputMismatchException er){
                System.out.println(er.getMessage());
                System.out.println("Please try again.");
                in.next();
            }
        }
        
        
        return carList;
    }
        
    public static String makeInput(String autoMake){ //DONE
        //loop for make input
        while(true){
            try{//try catch block
                
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
        return make;

    }
        
    public static String modelInput(String autoModel){ //DONE
            //loop for model input
            while(true){
                try{
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
            return model;
    }

    public static String colorInput(String autoColor){ //DONE
            //loop for color input
            while(true){
                try{
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
            return color;
        }
    
    public static int yearInput(int autoYear){ //DONE
            //loop for year input
            while(true){
                try{
                    if(in.hasNextInt()){
                        year = in.nextInt();
                        if (year < 1885){ //1885 was the year cars were first made
                             // input was invalid int
                            throw new IntException("Invalid year."); //out of bounds int
                        }
                        else if (year > 2023){ //no cars are further than '2023' model.
                            // invalid int
                            throw new IntException("Invalid year."); //out of bounds int
                        } else {
                            break;
                        }
                    }
                    else{
                        throw new InputMismatchException("Input was not an integer.");
                    }
                
                } catch (IntException er){
                    System.out.println(er.getException());
                    System.out.println("Please try again.");
                } catch (InputMismatchException excpt){
                    System.out.println(excpt.getMessage());
                    System.out.println("Input is not an integer!");
                    in.next();
                }
                
            }
            return year;
    }

    public static int mileageInput(int autoMileage){ //DONE
            //loop for mileage input
            while(true){
                try{

                    if(in.hasNextInt()){
                        mileage = in.nextInt();
                        if (mileage < 0){ //if the next integer is less than 0
                            throw new IntException("Invalid amount."); //out of bounds
                        } else {
                            //no errors detected, break from loop.
                            break;
                        }
                    } else {
                        throw new InputMismatchException("Input was not an integer.");
                    }
                } catch (IntException er){
                    System.out.println(er.getException());
                    System.out.println("Please try again.");
                } catch (InputMismatchException excpt){
                    System.out.println(excpt.getMessage());
                    System.out.println("Input is not an integer!");
                    in.next();
                }
                
            }
            return mileage; 
        }
    
    public static int setCapacity(){ //DONE
        while(true){
            try{
                System.out.println("Input the initial capacity of your inventory: ");
                if(in.hasNextInt()){ // if the next input is an int
                    capacity = in.nextInt(); //set capacity to next int
                    if (capacity <= 0){ //if capacity is <= 0, 
                        throw new IntException("Invalid amount."); //throw invalid input error
                    } else {
                        //no errors detected, break from loop.
                        break;// otherwise, break out of loop
                    }
                } else {
                    throw new InputMismatchException("Input was not an integer.");
                }
            } catch (IntException er){
                System.out.println(er.getException());
                System.out.println("Please try again.");
            
            } catch (InputMismatchException excpt){ // non integer mismatch
                System.out.println(excpt.getMessage()); //get error message
                System.out.println("Please try again.");
                in.next();
            }
        }
        return capacity;
    }
        
    static void removeVehicle(){ //DONE
        System.out.println("Which car would you like to remove?");
        for (int i = 0; i < carList.size(); i++){
            carList.remove(in.nextInt() - 1);
            }
        }

    static void updateVehicleAttributes(){ //TODO

    }

    public static void showMenu(){ //DONE
        System.out.println("Main Menu");
        System.out.println("1.) Add a vehicle ");
        System.out.println("2.) Remove a vehicle.");
        System.out.println("3.) List all Vehicles.");
        System.out.println("4.) Update a Vehicle.");
        System.out.println("5.) Exit");
        System.out.println("Please select your Menu Choice: ");

    }
    
    public static int menuOptions(int menuChoice){  //DONE/TODO
        do{ // menu will run at least once. program will keep going back to menu as long as program not exited
            showMenu();
            try{
                if(in.hasNextInt()){
                    menuChoice = in.nextInt();
                    switch(menuChoice){
                
                        case 1: //case for adding a vehicle
                            addVehicle(null); // this will create a new vehicle
                            break;
    
                        case 2: //case for removing a vehicle
                            removeVehicle(); //this will remove a vehicle
                            break;
    
                        case 3: //case for Listing all vehicles
                            listAllVehicleInfo(); //this will list the vehicle information
                            break;
    
                        case 4: //case for updating a vehicle
                            System.out.println("This section has not been added yet!"); //TODO
                            break;
    
                        case 5: //case for exiting a program.
                            System.out.println("Exiting program."); //TODO
                            System.exit(3);
                            break;
    
                        default: 
                            throw new IntException("Not a valid Menu Option. ");
    
                    }

                } else {
                    throw new InputMismatchException("Input was not a number. ");

                }
                
                
            } catch(InputMismatchException er) {
                System.out.println(er.getMessage());
                System.out.println("Please try again!");
                in.next();
                
            } catch(IntException excpt){
                System.out.println(excpt.getMessage());

            }


        }while(menuChoice != 5);
        return menuChoice;

    }

    
    public static void main(String[] args){
        System.out.println("Hi! We are going to store your vehicle information in your inventory.");
        setCapacity();
        
        menuOptions(0);
    }
    
}
