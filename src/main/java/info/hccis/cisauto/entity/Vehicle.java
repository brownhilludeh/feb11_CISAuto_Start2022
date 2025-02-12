package info.hccis.cisauto.entity;

import info.hccis.cisauto.util.CisUtility;

import java.util.Objects;
import java.util.Scanner;

/**
 * Add comment here
 *
 * @author BJ MacLean
 * @since Feb 27, 2015
 */
public class Vehicle {

    public enum StatusType {

        INSTOCK, SOLD;
        
    }

    public static final int TYPE_CAR = 1;
    public static final int TYPE_TRUCK = 2;
    public static final int TYPE_OTHER = 3;

    public static final String[] VEHICLE_TYPE_DESCRIPTIONS = {"", "Car", "Truck", "Other"};

    private int vehicleId;
    private int vehicleTypeCode;
    private double costToDealer;
    private double listPrice;
    private String make;
    private String model;
    private int modelYear;
    private StatusType statusType;
    private static int currentMaxVehicleId;

    /**
     * This constructor will accept values for the attributes.
     *
     * @since 20180215
     * @author cis1232
     *
     * @param vehicleTypeCode
     * @param costToDealer
     * @param price
     * @param make
     * @param model
     * @param modelYear
     * @param statusType
     */
    public Vehicle(int vehicleTypeCode, double costToDealer, double price, String make, String model, int modelYear, StatusType statusType) {
        setVehicleId();
        this.vehicleTypeCode = vehicleTypeCode;
        this.costToDealer = costToDealer;
        this.listPrice = price;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.statusType = statusType;
        if (CisUtility.DEBUGGING) {
            System.out.println("Created a new vehicle(passed in all attributes)");
            System.out.println(this.toString());
        }
    }

    /**
     * This constructor will accept values for the attributes.
     *
     * @since 20180215
     * @author cis1232
     *
     * @param vehicleTypeCode
     * @param costToDealer
     */
    // public Vehicle(int vehicleTypeCode, double costToDealer, int modelYear, StatusType statusType) {
    //     setVehicleId();
    //     this.vehicleTypeCode = vehicleTypeCode;
    //     this.costToDealer = costToDealer;
    //     this.modelYear = modelYear;
    //     this
    //     this.statusType = StatusType.INSTOCK;
    //     if (CisUtility.DEBUGGING) {
    //         System.out.println("Created a new vehicle(passed in all attributes)");
    //         System.out.println(this.toString());
    //     }
    // }

    /**
     * Default constructor
     *
     * @since 20180215
     * @author CIS1232
     */
    public Vehicle() {
        setVehicleId();
        if (CisUtility.DEBUGGING) {
            System.out.println("Created a new vehicle(using default constructor)");
            System.out.println(this.toString());
        }
    }

    /**
     * This method will prompt the user for the information required about this
     * vehicle.
     *
     * @return nothing
     * @since 20150227
     * @author cis1232
     */
    public void getInformation() {
        vehicleTypeCode = CisUtility.getInputInt("What type of vehichle(1=car, 2=truck, 3=other)?");
        costToDealer = CisUtility.getInputDouble("What is the cost to dealer");
        listPrice = CisUtility.getInputDouble("What is the list price?");
        make = CisUtility.getInputString("What is the make?");
        model = CisUtility.getInputString("What is the model?");
        modelYear = CisUtility.getInputInt("What is the vehicle year?");
        statusType = statusType.INSTOCK;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public static int getNextVehicleId() {
        currentMaxVehicleId++;
        return currentMaxVehicleId;
    }

    private synchronized void setVehicleId() {

        //Generate the vehicle id
        this.vehicleId = getNextVehicleId();
    }

    public int getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(int vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public double getCostToDealer() {
        return costToDealer;
    }

    public void setCostToDealer(double costToDealer) {
        this.costToDealer = costToDealer;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double price) {
        this.listPrice = price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getModelYear() == vehicle.getModelYear();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getModelYear());
    }

    /**
     * Method will display to the console
     *
     * @since 20180215
     * @author CIS1232
     */
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\nVehicle details:\n"
                + "vehicleId:  " + vehicleId
                + "\nvehicleTypeCode:  " + VEHICLE_TYPE_DESCRIPTIONS[vehicleTypeCode]
                + "\ncostToDealer=" + costToDealer
                + "\nlistPrice=" + listPrice
                + "\nmake:  " + make
                + "\nmodel:  " + model
                + "\nmodelYear:  " + modelYear
                + "\nstatusTypeCode:" + statusType
                + "\n-----------------------------\n";
    }



}
