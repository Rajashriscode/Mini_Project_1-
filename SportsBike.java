package sportBikeProject;

class SportsBike {


		 private String BikeName;
		 private String BikeId;
		 private double pricePerday;
		 private boolean isAvailable;

		 public SportsBike(String bikeName, String bikeId, double pricePerday) {
			BikeName = bikeName;
			BikeId = bikeId;
			this.pricePerday = pricePerday;
		    this.isAvailable= true;
		}
		public String getBikeName() {
			return BikeName;
		}

		public String getBikeId() {
			return BikeId;
		}
		public double calculatePrice(int rentalDays) {
		    return pricePerday * rentalDays;
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
