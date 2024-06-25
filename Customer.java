package sportBikeProject;

public class Customer {
	private String name;
	private String customerId;
	public Customer(String name, String customerId) {
		super();
		this.name = name;
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public String getCustomerId() {
		return customerId;
	}
}
