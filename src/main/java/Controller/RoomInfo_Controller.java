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
import model.dto.RoomInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfo_Controller implements Initializable {
    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
            new RoomInfoDTO("R001","Singal","one person",8000),
            new RoomInfoDTO("R002","Double","two person",12000),
            new RoomInfoDTO("R003","Tribal","three person",20000),
            new RoomInfoDTO("R004","Multy","Multy person",25000),
            new RoomInfoDTO("R005","Singal","one person",8000),
            new RoomInfoDTO("R006","Singal","one person",8000),
            new RoomInfoDTO("R007","Singal","one person",8000),
            new RoomInfoDTO("R008","Singal","one person",8000)
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
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

    @FXML
    private TextField txtDiscription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;

    @FXML
    void btnAddAction(ActionEvent event) {
        String id = txtRoomId.getText();
        String type = txtType.getText();
        String description = txtDiscription.getText();
        double price = Double.parseDouble(txtPrice.getText());

        RoomInfoDTO roomInfoDTO = new RoomInfoDTO(id,type,description,price);
        roomInfoDTOS.add(roomInfoDTO);
        tblRoomInfo.refresh();

        txtRoomId.setText("");
        txtType.setText("");
        txtDiscription.setText("");
        txtPrice.setText("");
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
        txtRoomId.setText("");
        txtType.setText("");
        txtDiscription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        RoomInfoDTO selectedItem = tblRoomInfo.getSelectionModel().getSelectedItem();
        roomInfoDTOS.remove(selectedItem);

        txtRoomId.setText("");
        txtType.setText("");
        txtDiscription.setText("");
        txtPrice.setText("");

        tblRoomInfo.refresh();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        RoomInfoDTO selectedItem = tblRoomInfo.getSelectionModel().getSelectedItem();
        selectedItem.setRoomId(txtRoomId.getText());
        selectedItem.setType(txtType.getText());
        selectedItem.setDescription(txtDiscription.getText());
        selectedItem.setPrice(Double.parseDouble(txtPrice.getText()));

        txtRoomId.setText("");
        txtType.setText("");
        txtDiscription.setText("");
        txtPrice.setText("");

        tblRoomInfo.refresh();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblRoomInfo.setItems(roomInfoDTOS);

        tblRoomInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                txtRoomId.setText(newValue.getRoomId());
                txtType.setText(newValue.getType());
                txtDiscription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });

    }
}
