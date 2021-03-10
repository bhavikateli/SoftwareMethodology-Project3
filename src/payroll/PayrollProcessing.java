package payroll;
/**
 * User interface class that reads/writes from/to the console.
 * @author Bhavika Teli and Eduardo Alba
*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
    public void run() {
        Company company = new Company();
        Scanner sc = new Scanner(System.in);

        System.out.println("Payroll Processing starts.");
        
        while (sc.hasNext()) {
            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            String command = st.nextToken();

            String name = "";
            String department = "";

            Date dateHired = new Date("1/01/2000"); // placeholder date
            Double salaryOrWage = 0.0;
            int workingHours = 0;
            int code = 0;

            // Quitting user input
            if (input.equals("Q")) {
                System.out.println("Payroll processing complete");
                break;
            }
            // calculate payments for all employees
            else if (command.equals("C")) {
                company.processPayments();
            }

            // print earnings for all employees
            else if (command.equals("PA")) {
                company.print();
            }
            // print earnings for all employee in order of date hired
            else if (command.equals("PH")) {
                company.printByDate();
            }
            // print earnings for all employee grouped by departments
            else if (command.equals("PD")) {
                company.printByDepartment();
            }

            // retrieve name, department, and date hired
            else if (st.hasMoreTokens() && command.equals("AP") || command.equals("AF") || command.equals("AM") || command.equals("R") || command.equals("S")) {
                name = st.nextToken();
                department = st.nextToken();
                dateHired = new Date(st.nextToken());

                if (dateHired.isValid()) {
                    if (department.equals("CS") || department.equals("ECE") || department.equals("IT")) {
                        // setting variables for add command
                        if (command.charAt(0) == 'A') {
                            salaryOrWage = Double.parseDouble(st.nextToken());
                            if (st.hasMoreTokens())
                                code = Integer.parseInt(st.nextToken());
                        }
                        // adding part time employee
                        if (command.equals("AP")) {
                            if (salaryOrWage >= 0) {
                                Employee employee = new Parttime(name, department, dateHired, salaryOrWage);
                                if (!company.add(employee))
                                    System.out.println("Employee is already in the list.");
                                else
                                    System.out.println("Employee added.");
                            } else {
                                System.out.println("Pay rate cannot be negative");
                            }
                        }
                        // add full time employee
                        else if (command.equals("AF")) {
                            if (salaryOrWage >= 0) {
                                Employee employee = new Fulltime(name, department, dateHired, salaryOrWage);
                                if (!company.add(employee))
                                    System.out.println("Employee is already in the list.");
                                else
                                    System.out.println("Employee added.");
                            } else {
                                System.out.println("Salary cannot be negative.");
                            }
                        }
                        // add management employee
                        else if (command.equals("AM")) {
                            if (salaryOrWage >= 0) {
                                Employee employee = new Management(name, department, dateHired, salaryOrWage, code);
                                if (code < 1 || code > 3)
                                    System.out.println("Invalid management code");
                                else if (!company.add(employee))
                                    System.out.println("Employee is already in the list.");
                                else
                                    System.out.println("Employee added.");
                            } else {
                                System.out.println("Salary cannot be negative.");
                            }
                        }

                        // remove employee from company
                        else if (command.equals("R")) {
                            Employee employee = new Employee(name, department, dateHired);
                            if (!company.remove(employee))
                                System.out.println("Employee does not exist.");
                            else
                                System.out.println("Employee removed.");
                        }

                        // set the working hours for part time employees
                        else if (command.equals("S")) {
                            if (st.hasMoreTokens())
                                workingHours = Integer.parseInt(st.nextToken());

                            if (workingHours <= 100) {
                                if (workingHours < 0) {
                                    System.out.println("Working hours cannot be negative.");
                                } else {
                                    Employee employee = new Parttime(name, department, dateHired, 0);
                                    if (employee instanceof Parttime) {
                                        Parttime emp = (Parttime) employee;
                                        emp.setHoursWorked(workingHours);
                                        if (company.setHours(emp))
                                            System.out.println("Working hours set.");
                                        else
                                            System.out.println("Employee database is empty");
                                    } else{
                                        System.out.println("Employee is not a parttime employee.");
                                    }
                                }
                            } else {
                                System.out.println("Invalid Hours: over 100");
                            }
                        }
                    } else {
                        System.out.println("Invalid Department Code");
                    }
                } else {
                    System.out.println(dateHired.toString() + " is not a valid date.");
                }
            } else {
                System.out.println("Command '" + command + "' is not supported!");
            }

        }
        sc.close();
    }
}
