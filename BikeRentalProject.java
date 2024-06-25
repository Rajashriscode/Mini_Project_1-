package BikeCodes;
public class BikeRentalProject{

    public static void main(String[] args) {
   
        BikeRentalSystem rentalSystem = new BikeRentalSystem();

        SportsBike bike1 = new SportsBike("B001", "NINJA", 300.0);
        SportsBike bike2 = new SportsBike("B002", "R15", 150.0);
        SportsBike bike3 = new SportsBike("B003", "KTM", 200.0);
        SportsBike bike4 = new SportsBike("B004", "DUKE", 250.0);
        SportsBike bike5 = new SportsBike("B005", "PULSER", 150.0);
        SportsBike bike6 = new SportsBike("B006", "Gixer", 120.0);
       
        rentalSystem.addBike(bike1);
        rentalSystem.addBike(bike2);
        rentalSystem.addBike(bike3);
        rentalSystem.addBike(bike4);
        rentalSystem.addBike(bike5);
        rentalSystem.addBike(bike6);
   

        rentalSystem.menu();
    }
}



