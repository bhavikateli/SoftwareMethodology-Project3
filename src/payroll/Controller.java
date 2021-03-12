package payroll;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

import java.time.LocalDate;

public class Controller {

    private Company company = new Company();


    @FXML
    private TextArea outputArea;

    @FXML
    private TextField nameTextField;

    @FXML
    private RadioButton csButton;

    @FXML
    private ToggleGroup departmentType;

    @FXML
    private RadioButton itButton;

    @FXML
    private RadioButton eceButton;

    @FXML
    private DatePicker dateHiredTextField;

    @FXML
    private RadioButton fullTimeButton;

    @FXML
    private ToggleGroup employeeType;

    @FXML
    private RadioButton partTimeButton;

    @FXML
    private RadioButton managementButton;

    @FXML
    private TextField annualSalaryTextField;

    @FXML
    private TextField hoursWorkedTextField;

    @FXML
    private TextField rateTextField;

    @FXML
    private RadioButton managerButton;

    @FXML
    private ToggleGroup managementType;

    @FXML
    private RadioButton departmentHeadButton;

    @FXML
    private RadioButton directionButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button removeEmployeeButton;

    @FXML
    private Button setHoursButton;

    @FXML
    private MenuButton fileMenuButton;

    @FXML
    private MenuItem importMenuItem;

    @FXML
    private MenuItem exportMenuItem;

    @FXML
    private MenuButton printMenuButton;

    @FXML
    private MenuItem allEmployeeMenuItem;

    @FXML
    private MenuItem dateHiredMenuItem;

    @FXML
    private MenuItem departmentMenuItem;

    @FXML
    private Button calculatePaymentButton;

    /**
     * Method when clear button is selected to clear all fields
     */
    @FXML
    private void clearScreen() {
        nameTextField.clear();

        annualSalaryTextField.clear();

        hoursWorkedTextField.clear();

        rateTextField.clear();

        dateHiredTextField.getEditor().clear();

        if(departmentType.getSelectedToggle() != null){
            departmentType.getSelectedToggle().setSelected(false);
        }

        if(employeeType.getSelectedToggle() != null){
            employeeType.getSelectedToggle().setSelected(false);
        }

        if(managementType.getSelectedToggle() != null){
            managementType.getSelectedToggle().setSelected(false);
        }

        managerButton.setDisable(false);
        departmentHeadButton.setDisable(false);
        directionButton.setDisable(false);
        annualSalaryTextField.setDisable(false);
        hoursWorkedTextField.setDisable(false);
        rateTextField.setDisable(false);
        setHoursButton.setDisable(false);

    }

    /**
     * Method to disable options according to selected employee type
     */
    @FXML
    private void disableOptions() {
        RadioButton status = (RadioButton) employeeType.getSelectedToggle();
        String employeeType = status.getText();

        if(employeeType.equals("Management")) {
            managerButton.setDisable(false);
            departmentHeadButton.setDisable(false);
            directionButton.setDisable(false);
            annualSalaryTextField.setDisable(false);
            hoursWorkedTextField.setDisable(true);
            rateTextField.setDisable(true);
            setHoursButton.setDisable(true);
        } else if(employeeType.equals("Part Time")){
            managerButton.setDisable(true);
            departmentHeadButton.setDisable(true);
            directionButton.setDisable(true);
            annualSalaryTextField.setDisable(true);
            hoursWorkedTextField.setDisable(false);
            rateTextField.setDisable(false);
            setHoursButton.setDisable(false);
        } else if(employeeType.equals("Full Time")){
            managerButton.setDisable(true);
            departmentHeadButton.setDisable(true);
            directionButton.setDisable(true);
            annualSalaryTextField.setDisable(false);
            hoursWorkedTextField.setDisable(true);
            rateTextField.setDisable(true);
            setHoursButton.setDisable(true);
        }

    }

    /**
     * Helper method to create profile when adding employee
     * @return Profile of current employee
     */
    @FXML
    private Profile getProfile() {
        try {
            RadioButton departmentTypeSelectedToggle = (RadioButton) departmentType.getSelectedToggle();
            String tempDepartment = departmentTypeSelectedToggle.getText();
            String tempName = nameTextField.getText();

            LocalDate tempLocalDate = dateHiredTextField.getValue();
            Date tempDate = new Date("" + tempLocalDate.getMonthValue() + "/" + tempLocalDate.getDayOfMonth() + "/" + tempLocalDate.getYear());

            if (tempDate.isValid() == false) {
                outputArea.appendText("Please input a valid date" +  "\n");
                return null;
            }

            Profile tempProfile = new Profile(tempName,tempDepartment, tempDate);
            return  tempProfile;

        } catch(NullPointerException e ){
            outputArea.appendText("Please fill out all the required fields" + "\n" );
            return null;
        }

    }

    /**
     * Helper method to create part-time employee when adding employee
     * @return Profile of current employee
     */
    @FXML
    private void partTimeEmployee(Profile profile) {
        try {
            String salaryString = rateTextField.getText();
            double tempSalary = Double.parseDouble(salaryString);

            if(tempSalary >= 0 ){
                Employee employee = new Parttime(profile, tempSalary);
                if(!company.add(employee)){
                    outputArea.appendText("Employee already in list" + "\n");
                }else{
                    outputArea.appendText("Employee added" + "\n");
                }
            } else{
                outputArea.appendText("Pay rate cannot be negative" + "\n") ;
            }
        } catch(NullPointerException e){
            outputArea.appendText("Please fill out all the required fields for PartTime"+ "\n");
        } catch(NumberFormatException e){
            outputArea.appendText("Please input a valid hourly rate" + "\n");
        }

    }

    /**
     * Helper method to create full-time employee when adding employee
     * @return Profile of current employee
     */
    @FXML
    private void fullTimeEmployee(Profile profile) {
        try {
            String salaryString = annualSalaryTextField.getText();
            double tempSalary = Double.parseDouble(salaryString);

            if(tempSalary >= 0 ){
                Employee employee = new Fulltime(profile, tempSalary);
                if(!company.add(employee)){
                    outputArea.appendText("Employee already in list" + "\n");
                }else{
                    outputArea.appendText("Employee added" + "\n");
                }
            } else{
                outputArea.appendText("Annual Salary cannot be negative" + "\n");
            }
        } catch(NullPointerException e){
            outputArea.appendText("Please fill out all the required fields for FullTime" + "\n");
        } catch(NumberFormatException e){
            outputArea.appendText("Please input a valid salary" + "\n");
        }
    }

    /**
     * Helper method to create management employee when adding employee
     * @return Profile of current employee
     */
    @FXML
    private void managementEmployee(Profile profile) {

        try {

            if(managementType.getSelectedToggle() == null){
                outputArea.appendText("Please select a management type" + "\n");
                return;
            }

            RadioButton employeeTypeSelectedToggle = (RadioButton) managementType.getSelectedToggle();
            String tempManagementType = employeeTypeSelectedToggle.getText();
            String annualSalaryString = annualSalaryTextField.getText();
            Double tempAnnualSalary = Double.parseDouble(annualSalaryString);
            int tempManagementCode = 0;

            if (tempManagementType.equals("Director")) {
                tempManagementCode = 3;
            } else if (tempManagementType.equals("Department Head")) {
                tempManagementCode = 2;
            } else if (tempManagementType.equals("Manager")) {
                tempManagementCode = 1;
            }

            if (tempAnnualSalary >= 0) {
                Employee employee = new Management(profile, tempAnnualSalary, tempManagementCode);
                if (!company.add(employee)) {
                    outputArea.appendText("Employee is already in the list" + "\n");
                } else {
                    outputArea.appendText("Employee added" + "\n");
                }
            } else {
                outputArea.appendText("Salary cannot be negative" + "\n");
            }

        } catch(NullPointerException e){
            outputArea.appendText("Please fill out all the required fields for Management" + "\n");

        }catch (NumberFormatException e){
            outputArea.appendText("Please input a valid number for salary" + "\n");
        }

    }

    /**
     * Method to give functionality to the add employee button
     */
    @FXML
    private void addEmployee() {
        try {
            RadioButton employeeTypeSelectedToggle = (RadioButton) employeeType.getSelectedToggle();
            String tempEmployeeType = employeeTypeSelectedToggle.getText();
            Profile tempProfile = getProfile();

            if(tempProfile == null){
                return;
            }

            if(tempEmployeeType.equals("Management")){
                managementEmployee(tempProfile);
            }else if(tempEmployeeType.equals("Part Time")){
                partTimeEmployee(tempProfile);
            }else if(tempEmployeeType.equals("Full Time")){
                fullTimeEmployee(tempProfile);
            }

        } catch(NullPointerException e ){
            outputArea.appendText("Please fill out all the required fields" + "\n");
        }

    }

    /**
     * Method to give functionality to remove button
     */
    @FXML
    private void removeEmployee() {
        try {
            Profile tempProfile = getProfile();
            Employee employee = new Employee(tempProfile);

            if(tempProfile == null){
                return;
            }

            if (!company.remove(employee)) {
                outputArea.appendText("Employee does not exist." + "\n");
            }
            else {
                outputArea.appendText("Employee removed." + "\n");
            }

        }catch (NullPointerException e){
            outputArea.appendText("Please fill out all required fields" + "\n");
        }


    }

    /**
     * Fuctionality to print all employees menu item
     */
    @FXML
    private void printAll() {
        if(company.getNumEmployee() == 0){
            outputArea.appendText("There are no employees in the database" + "\n");
        } else{
            outputArea.appendText("--Printing earning statements for all employees--" + "\n");
            outputArea.appendText(company.print());
        }

    }

    /**
     * Fuctionality to print by date hired menu item
     */
    @FXML
    private void printDateHired() {
        if(company.getNumEmployee() == 0){
            outputArea.appendText("There are no employees in the database" + "\n");
        } else{
            outputArea.appendText("--Printing earning statements for all employees--" + "\n");
            outputArea.appendText(company.printByDate());
        }
    }

    /**
     * Fuctionality to print all employees menu item
     */
    @FXML
    private void printDepartment() {
        if(company.getNumEmployee() == 0){
            outputArea.appendText("There are no employees in the database" + "\n");
        } else{
            outputArea.appendText("--Printing earning statements for all employees--" + "\n");
            outputArea.appendText(company.printByDepartment());
        }
    }

    /**
     * Functionality to sethours button
     */
    @FXML
    private void setHours() {
        try {
            Profile tempProfile = getProfile();
            String hoursWorkedString = hoursWorkedTextField.getText();
            int hoursWorked = Integer.parseInt(hoursWorkedString);

            if (hoursWorked <=  100) {
                if(hoursWorked < 0){
                    outputArea.appendText("Working hours cannot be negative");
                }else{
                    Employee employee = new Parttime(tempProfile, 0);
                    if (employee instanceof Parttime) {
                        Parttime emp = (Parttime) employee;
                        emp.setHoursWorked(hoursWorked);
                        if (company.setHours(emp))
                            outputArea.appendText("Working hours set.");
                        else
                            outputArea.appendText("Employee database is empty");
                    } else{
                        outputArea.appendText("Employee is not a parttime employee.");
                    }
                }
            }
        }catch(NumberFormatException e){
            outputArea.appendText("Please enter a valid numbers of hours");
        }

    }

    /**
     * Functionality to calculate payment button
     */
    @FXML
    void calculatePayment() {
        if(company.getNumEmployee() == 0){
            outputArea.appendText("There are no employees in the database" + "\n");
        } else{
            company.processPayments();
            outputArea.appendText("Calculation of employee payments is done."+ "\n");
        }
    }

    @FXML
    void exportFile(ActionEvent event) {

    }

    @FXML
    void importFile(ActionEvent event) {

    }

}

