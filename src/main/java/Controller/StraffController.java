package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;
import model.dto.StaffInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class StraffController implements Initializable {

    ObservableList<StaffInfoDTO> staffInfoDTOS = FXCollections.observableArrayList(
        new StaffInfoDTO("S001","Udara","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S002","Dewshan","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S003","Perera","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S004","Udara","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S005","Udara","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S007","Udara","Manager","udara@gmail.com","0704429957",350000),
        new StaffInfoDTO("S008","Udara","Manager","udara@gmail.com","0704429957",350000)
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
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStaffId;

    @FXML
    private TableView<StaffInfoDTO> tblStaffInfo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnBackAction(ActionEvent event) {

    }

    @FXML
    void btnClearAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         colStaffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
         colName.setCellValueFactory(new PropertyValueFactory<>("name"));
         colRole.setCellValueFactory(new PropertyValueFactory<>(""));
         colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
         tblStaffInfo.setItems(staffInfoDTOS);

        tblStaffInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                txtRoomId.setText(newValue.getStaffId());
                txtEmail.setText(newValue.getEmail());
                txtName.setText(newValue.getName());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtPhone.setText(newValue.getPhone());
            }
        });
    }
}
