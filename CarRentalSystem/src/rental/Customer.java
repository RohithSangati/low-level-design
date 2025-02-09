package rental;

public class Customer {

	private final int id;
	private final String name;
	private final String contactDetails;
	private final String licenceInfo;

	public Customer(String name, String contactDetails, String licenceInfo) {
		super();
		this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
		this.name = name;
		this.contactDetails = contactDetails;
		this.licenceInfo = licenceInfo;
	}

	public String getName() {
		return name;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public String getLicenceInfo() {
		return licenceInfo;
	}

	public int getId() {
		return id;
	}
}
