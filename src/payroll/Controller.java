package payroll;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;

public class Controller {

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
    private ToggleGroup statusType;

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
    void addEmployee(ActionEvent event) {

    }

    @FXML
    void clearScreen(ActionEvent event) {

    }

    @FXML
    void removeEmployee(ActionEvent event) {

    }

    @FXML
    void setHours(ActionEvent event) {

    }

}

