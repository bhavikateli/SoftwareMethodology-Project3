package payroll;

/**
 * class extends the Employee class and includes specific 
 * data and operations to a part-time employee.
 * @author Bhavika Teli and Eduardo Alba
*/
public class Parttime extends Employee{

    private static final int REGULAR_HOURS = 80;
    private static final double OVERTIME_MULTIPLIER = 1.5;

	private double hourlyWage;
    private int hoursWorked;

	 /**
     * Initial Constructor
     * @param name employee’s name in the form “lastname,firstname”
	 * @param department department code: CS, ECE, IT
	 * @param dateHired date employee was hired
	 * @param hourlyWage hourly rate
     */
    public Parttime(String name, String department, Date dateHired, double hourlyWage) {
        super(name,department,dateHired);
		this.hourlyWage = hourlyWage;
    }
    
	/**
	 * Method to calculate total payment in bi-weekly period
	 */
	@Override
	public void calculatePayment() { 

		double payment = 0;
		double normalPayment;
		int overtimeHours = hoursWorked - REGULAR_HOURS;

		if(overtimeHours > 0){
			double overtimePay = overtimeHours * (hourlyWage * OVERTIME_MULTIPLIER);
			payment = payment + overtimePay;
			normalPayment = hourlyWage * REGULAR_HOURS;
			payment = payment + normalPayment;
			super.setPayment(payment);

		} else{
			payment = hourlyWage * hoursWorked;
			super.setPayment(payment);
		}

	}	
	
	/**
	 * Converts Part-time variables into String format
	 * @return formatted String
	 */
	@Override
    public String toString(){
		String profileString = super.toString();
        String hourlyWageString = String.format("%.2f", this.hourlyWage);
        return (profileString + ":PART TIME::Hourly Rate $" + hourlyWageString + ":::Hours worked this period: " + hoursWorked);
		
    }

	/**
	 * Compares two part-time employees to check if they are equal
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
	 * Method to set hoursWorked for parttime employee
	 * @param hoursWorked
	 */
	public void setHoursWorked(int hoursWorked){
		if(hoursWorked < 0)
			hoursWorked = 0;
		this.hoursWorked = hoursWorked;
	}

	/**
	 * Method to return hours worked of current employee
	 * @return hours worked
	 */
	public int getHoursWorked(){
		return hoursWorked;
	}

	/**
	 * Method to return hourlyWage of current employee
	 * @return hourlyWage
	 */
	public double getHourlyWage(){
		return hourlyWage;
	}
}

