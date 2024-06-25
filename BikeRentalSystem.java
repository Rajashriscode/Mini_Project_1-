package BikeCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BikeRentalSystem {
    private List<SportsBike> bikes;
    private List<Customer> customers;
    private List<Rental> rentals;

    public BikeRentalSystem() {
        bikes = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addBike(SportsBike bike) {
        bikes.add(bike);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentBike(SportsBike bike, Customer customer, int days) {
        if (bike.isAvailable()) {
        bike.rent();
            rentals.add(new Rental(bike, customer, days));

        } else {
            System.out.println("Bike is not available for rent.");
        }
    }

    public void returnBike(SportsBike bike) {
    bike.returnBike();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getBike() == bike) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Bike was not rented.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****** Welcome to Bike Rental System ******");
            System.out.println();
            System.out.println("1. Rent a bike");
            System.out.println("2. Return a bike");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your Requirment Number: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
               
                System.out.print("Enter your full name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Bikes:");
                for (SportsBike bike : bikes) {
                    if (bike.isAvailable()) {
                        System.out.println(bike.getBikeId() + " - " + bike.getModel());
                    }
                }

                System.out.print("\nEnter the bike ID you want to rent: ");
                String bikeId = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                SportsBike selectedBike = null;
                for (SportsBike bike : bikes) {
                    if (bike.getBikeId().equals(bikeId) && bike.isAvailable()) {
                    selectedBike = bike;
                        break;
                    }
                }

                if (selectedBike != null) {
                    double totalPrice = selectedBike.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Bike: " + selectedBike.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentBike(selectedBike, newCustomer, rentalDays);
                        System.out.println("\nBike rented successfully.");
                        System.out.println();
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid bike selection or bike not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Bike ==\n");
                System.out.print("Enter the Bike ID you want to return: ");
                String bikeId = scanner.nextLine();

                SportsBike bikeToReturn = null;
                for (SportsBike bike : bikes) {
                    if (bike.getBikeId().equals(bikeId) && !bike.isAvailable()) {
                    bikeToReturn = bike;
                        break;
                    }
                }

                if (bikeToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getBike() == bikeToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnBike(bikeToReturn);
                        System.out.println("Bike returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Bike was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid bike ID or bike is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Bike Rental System!");
    }

}
