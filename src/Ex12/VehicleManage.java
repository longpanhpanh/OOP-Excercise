package Ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManage {
    List<Vehicle> vehicles;

    Scanner sc = new Scanner(System.in);

    public VehicleManage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean deleteVehicleById(String id) {
        return vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    public  List<Vehicle> findByColor(String color) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color))
                .toList();
    }

    public List<Vehicle> findByBrand(String brand) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();

    }

    public void start() {
            System.out.println("Vehicle Management Application");
            System.out.println("Enter 1: Add Vehicle");
            System.out.println("Enter 2: Delete Vehicle By Id");
            System.out.println("Enter 3: Find Vehicle by Color");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter Basic information: ");
                    System.out.println("Id: ");
                    String id = sc.nextLine();
                    System.out.println("Brand: ");
                    String brand = sc.nextLine();
                    System.out.println("Year: ");
                    int year  = sc.nextInt();
                    System.out.println("Price: ");
                    double price = sc.nextDouble();
                    System.out.println("Color: ");
                    String color = sc.nextLine();
                    System.out.println("Select Vehicle Type: ");
                    System.out.println("1: Car");
                    System.out.println("2: Motorcycle");
                    System.out.println("3: Truck");

                    String vehicleChoice = sc.nextLine();
                    switch (vehicleChoice) {
                        case "1":
                            System.out.println("Seats: ");
                            int seats = sc.nextInt();
                            System.out.println("Engine: ");
                            String engine = sc.nextLine();
                            sc.nextLine();
                            addVehicle(new Car(id, brand, year, price, color, seats, engine));
                            System.out.println("Car added.");
                            break;

                        case "2":
                            System.out.println();
                    }
            }
    }
}
