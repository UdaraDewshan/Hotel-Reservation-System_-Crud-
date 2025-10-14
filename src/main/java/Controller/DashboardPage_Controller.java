package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardPage_Controller {

    @FXML
    private Button btnCustomerInfo;

    @FXML
    private Button btnRoomInfomation;

    @FXML
    private Button btnStaff;

    @FXML
    void customerInfoAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerInfoPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 =(Stage) btnCustomerInfo.getScene().getWindow();
        stage1.close();
        stage.show();
    }

    @FXML
    void roomInfoAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RoomInfoPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 =(Stage) btnRoomInfomation.getScene().getWindow();
        stage1.close();
        stage.show();
    }

    @FXML
    void staffAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/StaffPage.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 =(Stage) btnStaff.getScene().getWindow();
        stage1.close();
        stage.show();
    }

}
