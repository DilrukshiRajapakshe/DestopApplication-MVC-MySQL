package IJSE.DEP.Countroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainCountroller {
    public AnchorPane MainFrame;
    public void GoToCustemerManagement(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/IJSE/DEP/View/CustermerView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void GoToTheInventryManagement(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/IJSE/DEP/View/ItemView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void GotoThePlaseOrder(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("//DEP/View/OderView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)MainFrame.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
}
