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

public class Controller {

    @FXML
    private TextArea outputArea;

    @FXML
    private TextField nameTextField, annualSalaryTextField, hoursWorkedTextField, rateTextField;

    @FXML
    private DatePicker dateHiredTextField;

    @FXML
    private ToggleGroup departmentType, employeeType, managementType;

    @FXML
    private RadioButton csButton, itButton, eceButton;

    @FXML
    private RadioButton fullTimeButton, partTimeButton, managementButton;

    @FXML
    private RadioButton managerButton, departmentHeadButton, directionButton;

    @FXML
    private Button clearButton, addEmployeeButton, removeEmployeeButton, setHoursButton;

    @FXML
    private MenuButton fileMenuButton;

    @FXML
    void addEmployee(ActionEvent event) {

    }

    /**
     * Method to disable options according to selected employee
     */
    @FXML
    public void disableOptions() {
        RadioButton status = (RadioButton) employeeType.getSelectedToggle();
        String employeeType = status.getText();

        if(employeeType.equals("Management")) {
            managerButton.setDisable(false);
            directionButton.setDisable(false);
            departmentHeadButton.setDisable(false);
            annualSalaryTextField.setDisable(false);
            hoursWorkedTextField.setDisable(true);
            rateTextField.setDisable(true);
        } else if(employeeType.equals("Part Time")){
            managerButton.setDisable(true);
            directionButton.setDisable(true);
            departmentHeadButton.setDisable(true);
            annualSalaryTextField.setDisable(true);
            hoursWorkedTextField.setDisable(false);
            rateTextField.setDisable(false);
        } else if(employeeType.equals("Full Time")){
            managerButton.setDisable(true);
            directionButton.setDisable(true);
            departmentHeadButton.setDisable(true);
            annualSalaryTextField.setDisable(false);
            hoursWorkedTextField.setDisable(true);
            rateTextField.setDisable(true);
        }

    }


    /**
     * Method when clear button is selected to clear all fields
     */
    @FXML
    void clearScreen() {
        nameTextField.clear();
        //nameTextField.setDisable(false);

        annualSalaryTextField.clear();
        //annualSalaryTextField.setDisable(false);

        hoursWorkedTextField.clear();
        //hoursWorkedTextField.setDisable(false);

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
        directionButton.setDisable(false);
        departmentHeadButton.setDisable(false);
        annualSalaryTextField.setDisable(false);
        hoursWorkedTextField.setDisable(false);
        rateTextField.setDisable(false);

        outputArea.clear();

    }

    @FXML
    void removeEmployee(ActionEvent event) {
        outputArea.appendText("yooooo");

    }

    @FXML
    void setHours(ActionEvent event) {

    }

}

