package payroll;

/**
 * class extends the Fulltime class and includes specific data 
 * and operations to a full-time employee with a management role.
 * @author Bhavika Teli and Eduardo Alba
*/
public class Management extends Fulltime{

	final static int MANAGER_CODE = 1;
    final static int DEPARTMENT_HEAD_CODE = 2;
    final static int DIRECTOR_CODE = 3;
    final static double MANAGER_COMPENSATION = 5000;
    final static double DEPARTMENT_HEAD_COMPENSATION = 9500;
    final static double DIRECTOR_COMPENSATION = 12000;

	public double compensation; 
	public String managementRole;
	public int managementCode;

	/**
	 * Initial constructor which sorts who compensation amount based on managementCode
	 * @param name employee’s name in the form “lastname,firstname”
	 * @param department department code: CS, ECE, IT
	 * @param dateHired date employee was hired
	 * @param salary annual salary
	 * @param managementCode code of position
	 */
	public Management(String name, String department, Date dateHired, double salary, int managementCode){
		super(name,department,dateHired,salary);
		if (managementCode == MANAGER_CODE) {
			this.managementRole = "Manager";
            compensation = MANAGER_COMPENSATION;
        } else if (managementCode == DEPARTMENT_HEAD_CODE) {
			this.managementRole = "DepartmentHead";
            compensation = DEPARTMENT_HEAD_COMPENSATION;
        } else if (managementCode == DIRECTOR_CODE) {
			this.managementRole = "Director";
            compensation = DIRECTOR_COMPENSATION;
        }

	}
	/**
	 * Method to calculate salary per period of management employee
	 */
	@Override
	public void calculatePayment() { 
		double salary = getSalary();
		double payment = (salary + compensation)/PAY_PERIODS;
		super.setPayment(payment);
	}
	
	/**
	 * Converts Management variables into String format
	 * @return formatted String
	 */
	@Override
    public String toString(){

		double perodicCompensation = compensation/PAY_PERIODS;
        String compensationString = String.format("%.2f", perodicCompensation);
        return (super.toString() + "::" + managementRole + " Compensation: $" + compensationString);
		
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
	
}

