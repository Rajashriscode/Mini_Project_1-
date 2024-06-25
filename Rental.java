package sportBikeProject;

public class Rental {
	private SportsBike bike;
    private Customer customer;
    private int days;

    public Rental(SportsBike bike, Customer customer, int days) {
        this.bike = bike;
        this.customer = customer;
        this.days = days;
    }

    public SportsBike getBike() {
        return bike;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}
