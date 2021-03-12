package payroll;

/**
 * This class defines the abstract data type Profile, 
 * which encapsulates the data fields for an employee.
 * @author Bhavika Teli and Eduardo Alba
*/
public class Profile {

	private String name; //employee’s name in the form “lastname,firstname”
	private String department; //department code: CS, ECE, IT
	private Date dateHired;

	/**
	 * Constructor that sets instance variables to Profile class
	 * @param name employee’s name in the form “lastname,firstname”
	 * @param department department code: CS, ECE, IT
	 * @param dateHired date employee was hired
	 */
	public Profile(String name, String department, Date dateHired){
		this.name = name;
		this.department = department;
		this.dateHired = dateHired;
	}

	/**
	 * Converts variables of profile into String format
	 * @return String with all of book's information
	 */
	@Override
	public String toString() { 
		return name + "::" + department + "::" + dateHired.toString();
	}

	/**
	 * Compares name, department and dateHired of two profile to see if they are equal
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) { 

		Profile profile = (Profile) obj;

		if(profile == null) { return false; }

		int compareName = profile.name.compareTo(this.name);
		int compareDepartment = profile.department.compareTo(this.department);
		int compareDateHired = profile.dateHired.compareTo(this.dateHired);
		return (compareName == 0 && compareDepartment == 0 && compareDateHired == 0);
	
	}

	/**
	 * Fetches and returns profiles name variable
	 * @return name variable
	 */
	public String getName(){
		return name;
	}

	/**
	 * Fetches and returns profiles department variable
	 * @return department variable
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Fetches and returns profiles dateHired variable
	 * @return dateHired variable
	 */
	public Date getDateHired() {
		return dateHired;
	}
}

