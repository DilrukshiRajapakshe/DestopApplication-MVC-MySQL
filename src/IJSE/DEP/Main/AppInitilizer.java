package IJSE.DEP.Main;

import IJSE.DEP.DB.DbConnecter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AppInitilizer extends Application {

    public  static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbConnecter.conn();
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/IJSE/DEP/View/MainView.fxml"));
        Parent root = loader.load();

        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("FX Student");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
