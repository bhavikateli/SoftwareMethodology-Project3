package payroll;

/**
 * Class extends the Employee class and includes specific 
 * data and operations to a full-time employee.
 * @author Bhavika Teli and Eduardo Alba
 */

public class Fulltime extends Employee{

	final static int PAY_PERIODS = 26;

	private double salary;
    
	 /**
     * Initial Constructor
     * @param name employee’s name in the form “lastname,firstname”
	 * @param department department code: CS, ECE, IT
	 * @param dateHired date employee was hired
	 * @param salary annual salary
     */
	public Fulltime(String name, String department, Date dateHired, double salary){
		super(name,department,dateHired);
		this.salary = salary;
	}

	/**
	 * Initial constructor with profile param
	 * @param profile to add
	 * @param salary hourly rate
	 */
	public Fulltime(Profile profile, double salary){
		super(profile);
		this.salary = salary;
	}

	/**
	 * Method to calculate salary per period of fulltime employee
	 */
	@Override
	public void calculatePayment() { 
		double payment = (salary)/PAY_PERIODS;
		super.setPayment(payment);
	}	

	/**
	 * Converts Full-time variables into String format
	 * @return formatted String
	 */
	@Override
    public String toString(){
		String profileString = super.toString();
        String salaryString = String.format("%.2f", this.salary);
        return (profileString + "::FULL TIME::Annual Salary $" + salaryString);
		
    }

	/**
	 * Compares two fulltime employees to check if they are equal
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj){ 
		if(obj instanceof Employee){
			return super.equals(obj);
		}
		return false;
	}

	 /**
     * Method to set the compensation for full time employee.
     * @return annual salary
     */
    public double getSalary() {
        return salary;
    }
	
}