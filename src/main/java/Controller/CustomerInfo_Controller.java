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
import model.dto.CustomerInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfo_Controller implements Initializable {
    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("U001","udara","0717082645","Panadura",18),
            new CustomerInfoDTO("U002","Dewshan","0717082645","Panadura",18),
            new CustomerInfoDTO("U003","Pesandu","0717082645","Panadura",22),
            new CustomerInfoDTO("U004","Shashith","0717082645","Panadura",28),
            new CustomerInfoDTO("U005","Methnula","0717082645","Panadura",88),
            new CustomerInfoDTO("U006","Dilan","0717082645","Panadura",58)
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
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomer;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void btnAddAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String phoneNo = txtPhone.getText();
        String city = txtCity.getText();
        int age = Integer.parseInt(txtAge.getText());

        CustomerInfoDTO customerInfoDTOs = new CustomerInfoDTO(id,name,phoneNo,city,age);
        customerInfoDTOS.add(customerInfoDTOs);
        tblCustomer.refresh();

        txtAge.setText("");
        txtCustomerId.setText("");
        txtPhone.setText("");
        txtName.setText("");
        txtCity.setText("");
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
        txtAge.setText("");
        txtCity.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtCustomerId.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        CustomerInfoDTO setSelectItem = tblCustomer.getSelectionModel().getSelectedItem();
        customerInfoDTOS.remove(setSelectItem);
        tblCustomer.refresh();

        txtAge.setText("");
        txtCustomerId.setText("");
        txtPhone.setText("");
        txtName.setText("");
        txtCity.setText("");
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        CustomerInfoDTO selectItem = tblCustomer.getSelectionModel().getSelectedItem();
        selectItem.setId(txtCustomerId.getText());
        selectItem.setName(txtName.getText());
        selectItem.setPhoneNo(txtPhone.getText());
        selectItem.setCity(txtCity.getText());
        selectItem.setAge(Integer.parseInt(txtAge.getText()));

        txtAge.setText("");
        txtCustomerId.setText("");
        txtPhone.setText("");
        txtName.setText("");
        txtCity.setText("");

        tblCustomer.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));

        tblCustomer.setItems(customerInfoDTOS);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue != null){
                txtCustomerId.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtPhone.setText(newValue.getPhoneNo());
                txtCity.setText(newValue.getCity());
                txtAge.setText(String.valueOf(newValue.getAge()));
            }
        });
    }
}
