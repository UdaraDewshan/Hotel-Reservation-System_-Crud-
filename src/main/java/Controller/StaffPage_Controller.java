package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.StaffInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffPage_Controller implements Initializable {

    ObservableList<StaffInfoDTO> staffInfoDTOS = FXCollections.observableArrayList(
            new StaffInfoDTO("S001","Udara","Resciptionist","udara@gmail.com","0704429957",350000),
            new StaffInfoDTO("S002","Udara","Manager","udara@gmail.com","0704429957",350000),
            new StaffInfoDTO("S003","Udara","Housekeeping","udara@gmail.com","0704429957",350000),
            new StaffInfoDTO("S004","Udara","Resciptionist","udara@gmail.com","0704429957",350000),
            new StaffInfoDTO("S005","Udara","Resciptionist","udara@gmail.com","0704429957",350000),
            new StaffInfoDTO("S006","Udara","Resciptionist","udara@gmail.com","0704429957",350000)
    );
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colSallry;

    @FXML
    private TableColumn<?, ?> colStaff;

    @FXML
    private TableView<StaffInfoDTO> tblStaff;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStaffId;

    @FXML
    void btnAddAction(ActionEvent event) {
        String id = txtStaffId.getText();
        String name = txtName.getText();
        String role =txtRole.getText();
        String email = txtEmail.getText();
        String phoneNo = txtPhoneNo.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        StaffInfoDTO staffInfoDTOs = new StaffInfoDTO(id,name,role,email,phoneNo,salary);
        staffInfoDTOS.add(staffInfoDTOs);

        txtStaffId.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtSalary.setText("");
        txtPhoneNo.setText("");

        tblStaff.refresh();
    }

    @FXML
    void btnBackAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardPage.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearAction(ActionEvent event) {
        txtStaffId.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtSalary.setText("");
        txtPhoneNo.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        StaffInfoDTO selectItem = tblStaff.getSelectionModel().getSelectedItem();
        staffInfoDTOS.remove(selectItem);
        tblStaff.refresh();

        txtStaffId.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtSalary.setText("");
        txtPhoneNo.setText("");
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        StaffInfoDTO selectItem = tblStaff.getSelectionModel().getSelectedItem();
        selectItem.setStaffId(txtStaffId.getText());
        selectItem.setEmail(txtEmail.getText());
        selectItem.setRole(txtRole.getText());
        selectItem.setName(txtName.getText());
        selectItem.setPhone(txtPhoneNo.getText());
        selectItem.setSalary(Double.parseDouble(txtSalary.getText()));

        tblStaff.refresh();

        txtStaffId.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtSalary.setText("");
        txtPhoneNo.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colStaff.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSallry.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblStaff.setItems(staffInfoDTOS);

        tblStaff.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                txtStaffId.setText(newValue.getStaffId());
                txtName.setText(newValue.getName());
                txtRole.setText(newValue.getRole());
                txtEmail.setText(newValue.getEmail());
                txtPhoneNo.setText(newValue.getPhone());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
            }
        });
    }
}


