package BikeCodes;

class SportsBike {
    private String BikeId;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public SportsBike(String bikeId, String model, double basePricePerDay) {
        this.BikeId = bikeId;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }
   
    public String getBikeId() {
        return BikeId;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnBike() {
        isAvailable = true;
    }
}



