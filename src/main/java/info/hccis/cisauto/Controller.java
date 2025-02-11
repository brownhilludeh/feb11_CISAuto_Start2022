package info.hccis.cisauto;

import info.hccis.cisauto.entity.Vehicle;
import info.hccis.cisauto.util.CisUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Main class to control overall program functionality.
 *
 * @author BJ MacLean
 * @since Nov 5, 2014
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    // for later....private static HashMap<Integer, Vehicle> inventory = new HashMap();
    private static ArrayList<Vehicle> inventoryList = new ArrayList();
    
    public static final String NAME_OF_BUSINESS = "CIS Auto Sales";

    public static final String MENU = NAME_OF_BUSINESS + "\n"
            + "Choose one  of the following options:\n"
            + "A - Add a vehicle\n"
            + "B - Show inventory\n"
            + "C - Display number of vehicles in inventory\n"
            + "X – eXit";

    public static final String INVENTORY_COUNT_OUTPUT_1 = NAME_OF_BUSINESS + "";
    public static final String INVENTORY_COUNT_OUTPUT_2 = "Number of cars:  #";
    public static final String INVENTORY_COUNT_OUTPUT_3 = "Number of trucks:  #";
    public static final String INVENTORY_COUNT_OUTPUT_4 = "Number of other:  #";

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Vehicle testOne = new Vehicle(Vehicle.TYPE_CAR, 6000.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.INSTOCK);
        Vehicle testTwo = new Vehicle(Vehicle.TYPE_CAR, 3000.0, 5000, "Ford", "Focus", 2007, Vehicle.StatusType.INSTOCK);

//        inventory.put(testOne.getVehicleId(), testOne);
//        inventory.put(testTwo.getVehicleId(), testTwo);
        inventoryList.add(testOne);
        inventoryList.add(testTwo);

        String userOption = null;

        do {
            userOption = processOption();
        } while (!userOption.equalsIgnoreCase("X"));

    }

    /**
     * Processed the main menu options.
     *
     * @author cis1232
     * @since 20180215
     * @return menu option chosen
     */
    public static String processOption() {
        System.out.println(MENU);
        String userOption = input.nextLine().toUpperCase();

        if (CisUtility.DEBUGGING) {
            System.out.println("Processing for " + userOption);
        }
        switch (userOption) {
            case "A":
                //todo requirement 2 add a vehicle
                break;
            case "B":
                showInventory();
                break;
            case "C":
                showInventoryCounts();
                break;
            case "X":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid option");
        }
        return userOption;
    }

    /**
     * Show inventory of vehicles
     * @since 20180215
     * @author cis1232
     */
    public static void showInventory() {
        //todo requirement 3 - show inventory

        for (Vehicle vehicle : inventoryList) {
            vehicle.display();
        }
    }

        /**
     * This will show the inventory counts based on vehicle type
     *
     * @since 20150227
     * @author cis1232
     */
    public static void showInventoryCounts() {
        //todo requirement 4 - show counts by vehicle type.
    }

}
