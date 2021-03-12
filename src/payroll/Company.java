package payroll;

/**
 * class is an array-based container class that implements 
 * the employee database.
 * 
 * @author Bhavika Teli and Eduardo Alba
 */

public class Company {

	final static int GROW_SIZE = 4;
	final static int NOT_FOUND = -1;
	final static int INCREMENT = 1;
	final static String[] DEPARTMENTS = { "CS", "ECE", "IT" };

	private Employee[] emplist;
	private int numEmployee;

	/**
	 * Default Constructor
	 */
	public Company() {
		this.emplist = new Employee[4];
		this.numEmployee = 0;
	}

	/**
	 * Method to find the index of employee in emplList
	 * @param employee to be found
	 * @return index, else -1 if not found
	 */
	private int find(Employee employee) {
		if (employee.getProfile() == null) return NOT_FOUND;

		for (int i = 0; i < numEmployee; i++)
			if (emplist[i] != null && emplist[i].equals(employee)) return i;
	
		return NOT_FOUND;
	}

	/**
	 * Helper method to grow the capacity of Company by 4
	 */
	private void grow() {
		Employee[] temp = new Employee[numEmployee + GROW_SIZE];
		for (int i = 0; i < emplist.length; i++) {
			temp[i] = emplist[i];
		}
		emplist = temp;
	}

	/**
	 * Helper method to add a new employee
	 * @param employee to add
	 * @return true if added, false otherwise
	 */
	public boolean add(Employee employee) {
		// if employee does not exist in array
		if (find(employee) == NOT_FOUND) {
			if (numEmployee == emplist.length) grow();
			emplist[numEmployee++] = employee;
		}
		else return false;
		return true;
	}

	/**
	 * Helpger method to remove an existing employee
	 * @param employee to remove
	 * @return true if removed, false otherwise
	 */
	public boolean remove(Employee employee) {
		int index = find(employee);
		// if employee exists in array
		if (index != NOT_FOUND) {
			emplist[index] = null; // set employee to null
			for (int i = index; i < emplist.length - 1; i++)
				emplist[i] = emplist[i + 1];
			numEmployee--;

		}
		else return false;
		return true;
	}

	/**
	 * Helper method to set working hours for a part time
	 * @param employee
	 * @return true to set, false otherwise
	 */
	public boolean setHours(Employee employee) {
		int index = find(employee);
		if(index != NOT_FOUND){
			if(employee instanceof Parttime){
				//Get hourly wage of employee with same profile
				Parttime emp = (Parttime) emplist[index];
				double hourlyWage = emp.getHourlyWage();

				//Get hours worked
				Parttime hoursWorked = (Parttime) employee;
				int hours = hoursWorked.getHoursWorked();

				//Create new parttime employee with new hours worked
				Profile profile = employee.getProfile();
				Parttime temp = new Parttime(profile.getName(), profile.getDepartment(), profile.getDateHired(), hourlyWage);

				temp.setHoursWorked(hours);
				emplist[index] = temp;
				return true;
			}
		}
		return false;
	}

	/**
	 * Helper method to process payments for all employees
	 */
	public void processPayments() {

			for (int i = 0; i < numEmployee; i++) {
				Employee currEmployee = emplist[i];
				currEmployee.calculatePayment();
			}
		}


	/**
	 * Helper method to print earning statements for all employees
	 */
	public String print() {
		String result = "";
			for (int i = 0; i < numEmployee; i++) {
				Employee currEmployee = emplist[i];
				result = result + (currEmployee.toString() + "\n");
			}
			return result;
	}

	/**
	 * Helper method to print earning statements by department
	 */
	public String printByDepartment() {

		String result = "";

		for (String department : DEPARTMENTS) {
			for (int i = 0; i < numEmployee; i++) {
				Employee currEmployee = emplist[i];
				Profile profile = currEmployee.getProfile();

				if (profile.getDepartment().equals(department)) {
					result = result + currEmployee.toString() + "\n";
				}
			}
		}

		return result;
	}

	/**
	 * Helper method to print earning statements by date hired
	 */
	public String printByDate() {

		String result = "";
			Employee[] temp = sortByDate(emplist);
			for (int i = 0; i < numEmployee; i++) {
				Employee curreEmployee = temp[i];
				result = result + curreEmployee.toString() + "\n";
			}
			return result;
		}


	/**
	 * Helper method to sort by date
	 * @param arr empList
	 * @return sorted Date list
	 */
	public Employee[] sortByDate(Employee[] arr) {
		int n = arr.length;
		Employee[] temp = new Employee[n];

		// copy contents of employee list into temp array
		for (int i = 0; i < n; i++)
			temp[i] = arr[i];

		// sort temp array by date in ascending order using insertion sort
		for (int i = 1; i < n; i++) {
			Employee key = temp[i];
			if (key != null) {
				Date keyDateHired = key.getProfile().getDateHired();
				int j = i - INCREMENT;

				while (j >= 0 && temp[j].getProfile().getDateHired().compareTo(keyDateHired) >= 0) {
					temp[j + INCREMENT] = temp[j];
					j -= INCREMENT;
				}
				temp[j + INCREMENT] = key;
			}
		}
		return temp;
	}

	public int getNumEmployee(){
		return numEmployee;
	}
}