package sample;

/**
 * Class defines the common data and operations for all employee type; 
 * each employee has a profile that uniquely identifies the employee.
 * @author Bhavika Teli and Eduardo Alba
*/

public class Employee {

	private Profile profile;
	private double payment;

	/**
	 * Default constructor for Employee
	 */
	public Employee(){ }
	
	/**
	 * Initial constructor to create the Employee object and connect with profile.
	 * @param name employee’s name in the form “lastname,firstname”
	 * @param department department code: CS, ECE, IT
	 * @param dateHired date employee was hired
	 */
	public Employee(String name, String department, Date dateHired) {
        profile = new Profile(name,department,dateHired);
	}

	/**
     * Holder method as superclass
     */
    public void calculatePayment() {}
	
	/**
	 * Converts employee variables into String format
	 * @return formatted String
	 */
	@Override
    public String toString() {
		String profileString = profile.toString();
        String paymentString = String.format("%.2f", this.payment);
        return profileString + "::Payment $" + paymentString + "::";
    }
	
	/**
	 * Compares two employees to check if they are equal
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj){ 
		if(obj instanceof Employee){
			Employee employee = (Employee) obj;
			Profile profileCompare = employee.getProfile();
			return (profileCompare.equals(this.profile));
		}
		return false;
	}


	/**
	 * Takes in a double to set to payment variable
	 * @param payment to set to payment variable
	 */
	public void setPayment(Double payment){
		this.payment = payment;
	}

	/**
	 * Method to return payment of current employee
	 * @return payment
	 */
	public double getPayment(){
		return payment;
	}

	/**
	 * Method to return profile of current employee
	 * @return profile
	 */
	public Profile getProfile(){
		return this.profile;
	}
	
}