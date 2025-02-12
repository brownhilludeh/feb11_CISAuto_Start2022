package info.hccis.cisauto;

import info.hccis.cisauto.entity.Vehicle;
import info.hccis.cisauto.util.CisUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
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
    // for later....private static HashMap<Integer, Vehicle> inventory = new
    // HashMap();
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

        Vehicle testOne = new Vehicle(Vehicle.TYPE_CAR, 6000.0, 8000, "Honda", "Accord", 2009,
                Vehicle.StatusType.INSTOCK);
        Vehicle testTwo = new Vehicle(Vehicle.TYPE_CAR, 3000.0, 5000, "Ford", "Focus", 2007,
                Vehicle.StatusType.SOLD);
        Vehicle testThree = new Vehicle(Vehicle.TYPE_OTHER, 5500.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.INSTOCK);
        Vehicle testFour = new Vehicle(Vehicle.TYPE_TRUCK, 700.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.INSTOCK);
        Vehicle testFive = new Vehicle(Vehicle.TYPE_OTHER, 1700.0, 8000, "Honda", "Accord", 2009, Vehicle.StatusType.INSTOCK);

        // inventory.put(testOne.getVehicleId(), testOne);
        // inventory.put(testTwo.getVehicleId(), testTwo);
        inventoryList.add(testOne);
        inventoryList.add(testTwo);
        inventoryList.add(testThree);
        inventoryList.add(testFour);
        inventoryList.add(testFive);

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
                // todo requirement 2 add a vehicle
                Vehicle vehicle = new Vehicle();
                vehicle.getInformation();
                inventoryList.add(vehicle);
                break;
            case "B":
                showInventory();
                break;
            case "C":
                showInventoryCounts();
                break;
            case "D":
                showInStockVehicles();
                break;
            case "E":
                loadAHashSet();
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
     * 
     * @since 20180215
     * @author cis1232
     */
    public static void showInventory() {
        // todo requirement 3 - show inventory

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
        // todo requirement 4 - show counts by vehicle type.
        int carCount = 0;
        int truckCount = 0;
        int otherCount = 0;

        for (Vehicle vehicle : inventoryList) {
            if (vehicle.getStatusType().equals(Vehicle.StatusType.INSTOCK)) {
                // switch (vehicle.getVehicleTypeCode()) {
                //     case Vehicle.TYPE_CAR:
                //         carCount++;
                //         break;
                //     case Vehicle.TYPE_TRUCK:
                //         truckCount++;
                //         break;
                //     case Vehicle.TYPE_OTHER:
                //         otherCount++;
                //         break;
                //     default:
                //         break;
                // }
                // if (vehicle.getVehicleTypeCode() == Vehicle.TYPE_CAR) {
            }
        }

        System.out.println(INVENTORY_COUNT_OUTPUT_1);
        System.out.println(INVENTORY_COUNT_OUTPUT_2 + carCount);
        System.out.println(INVENTORY_COUNT_OUTPUT_3 + truckCount);
        System.out.println(INVENTORY_COUNT_OUTPUT_4 + otherCount);

    }

    public static void showInStockVehicles() {
        // todo requirement 5 - show vehicles in stock
        ListIterator<Vehicle> inStockIterator = inventoryList.listIterator();
        while (inStockIterator.hasNext()) {
            Vehicle vehicle = inStockIterator.next();
            if (vehicle.getStatusType().equals(Vehicle.StatusType.INSTOCK)) {
                vehicle.display();
            }
        }
    }

    public static void loadAHashSet() {
        // TODO 7 - Add a menu item which will load all of the vehicles into a HashSet<Vehicle>

        // HashSet<String> hashSet = new HashSet<>();
        // hashSet.add("A");
        // hashSet.add("B");
        // hashSet.add("C");
        // hashSet.add("D");
        // hashSet.add("E");
        // hashSet.add("F");
        // hashSet.add("G");
        // hashSet.add("H");
        // hashSet.add("I");
        // hashSet.add("J");
        // hashSet.add("K");
        // hashSet.add("L");
        // hashSet.add("M");
        // hashSet.add("N");
        // hashSet.add("O");
        // hashSet.add("P");
        // System.out.println(hashSet);
        // System.out.println(hashSet.size());

        HashSet<Vehicle> hashSetVehicle = new HashSet<>();
        // for (Vehicle vehicle : inventoryList) {
        //     hashSetVehicle.add(vehicle);
        // }
        // inventoryList.add(new Vehicle());
        // hashSetVehicle.addAll(inventoryList.addAll(inventoryList));
        System.out.println(hashSetVehicle);
        System.out.println(hashSetVehicle.size());

    }

}
