package IJSE.DEP.Countroller;

import IJSE.DEP.DB.DbConnecter;
import IJSE.DEP.Module.Customer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static sun.plugin.ClassLoaderInfo.reset;

public class CustomerController {
    @FXML
    public AnchorPane CustomerForm;
    @FXML
    private TextField CustermerId;
    @FXML
    private TextField CustomerAddress;
    @FXML
    private TextField CustomerName;
    @FXML
    private TextField TelNo;
    @FXML
    private TableView<Customer> CustomerTable;
    Connection conn=null;

    public void initialize() throws SQLException, ClassNotFoundException {

        CustomerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CuId"));
        CustomerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("CuName"));
        CustomerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CuAddress"));
        CustomerTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("CuTel"));
        viewTable();
        CustomerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observable, Customer oldValue, Customer newValue) {
                CustermerId.setText(newValue.getCuId());
                CustomerName.setText(newValue.getCuName());
                CustomerAddress.setText(newValue.getCuAddress());
                TelNo.setText(String.valueOf(newValue.getCuTel()));
                CustermerId.setEditable(false);
                CustomerName.setEditable(true);
                CustomerAddress.setEditable(true);
                TelNo.setEditable(true);
            }
        });

    }

    public void CreatNewCustomer(ActionEvent actionEvent) {
        CustermerId.setEditable(true);
        CustomerName.setEditable(true);
        CustomerAddress.setEditable(true);
        TelNo.setEditable(true);
        CustermerId.clear();
        CustomerName.clear();
        CustomerAddress.clear();
        TelNo.clear();
        CustomerTable.getSelectionModel().clearSelection();
    }

    public void GoToTheBack(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/IJSE/DEP/View/MainView.fxml"));
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)CustomerForm.getScene().getWindow();
        primaryStage.setScene(se);
    }

    public void SaveCustomer(ActionEvent actionEvent)throws SQLException, ClassNotFoundException  {
        String Cid=CustermerId.getText();
        String Cname=CustomerName.getText();
        String Cadd=CustomerAddress.getText();
        int tel = Integer.parseInt(TelNo.getText());
        String Stel= String.valueOf(tel);
        boolean f =CheakId(Cid);
        int x = CustomerTable.getSelectionModel().getSelectedIndex();
        if(Cid.trim().isEmpty()){
            System.out.println("Custermer Id is empty");
        }else if(Cname.trim().isEmpty()){
            System.out.println("Custermer name is empty");
        }else if(Cadd.trim().isEmpty()){
            System.out.println("Custermer address is empty");
        }else if(Stel.trim().isEmpty()){
            System.out.println("Custermer tel is empty");
        }
        else {
            if ( f  && CustomerTable.getSelectionModel().isEmpty()) {
                conn = (Connection) DbConnecter.conn();
                String query2 = ("INSERT INTO customerInfo(CuId,CuName,CuAddress,CuTel) VALUES (?,?,?,?)");
                PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
                ps2.setObject(1, Cid);
                ps2.setObject(2, Cname);
                ps2.setObject(3, Cadd);
                ps2.setObject(4, tel);
                int s = ps2.executeUpdate();
                if (s > 0) {
                    System.out.println("Add");
                    new Alert(Alert.AlertType.ERROR, "Customer Details are add", ButtonType.OK).show();
                    CustermerId.setEditable(false);
                    CustomerName.setEditable(false);
                    CustomerAddress.setEditable(false);
                    TelNo.setEditable(false);
                    viewTable();
                } else {
                    System.out.println("1Error");
                    new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK).show();
                }
            }else if(CustomerTable.getSelectionModel().isEmpty() && f== false){
                new Alert(Alert.AlertType.ERROR, "Customer are already have in", ButtonType.OK).show();
            }else {
                conn = (Connection) DbConnecter.conn();
                PreparedStatement ps1 = conn.prepareStatement("UPDATE customerInfo SET  CuName=?, CuAddress=?, CuTel=? WHERE CuId=?");
                ps1.setObject(1, Cname);
                ps1.setObject(2, Cadd);
                ps1.setObject(3, tel);
                ps1.setObject(4, Cid);
                int s = ps1.executeUpdate();
                //CustomerTable.r
                if (s > 0) {
                    System.out.println("Update");
                    new Alert(Alert.AlertType.ERROR, "Customer Details are Update", ButtonType.OK).show();
                    CustermerId.setEditable(false);
                    CustomerName.setEditable(false);
                    CustomerAddress.setEditable(false);
                    TelNo.setEditable(false);
                    //CustomerTable.
                    CustomerTable.getSelectionModel().clearSelection();

                } else {
                    System.out.println("2Error");
                    new Alert(Alert.AlertType.ERROR, "Error", ButtonType.OK).show();
                }
            }
        }
    }

    public void DeletedCustomer(ActionEvent actionEvent) {
        int x = CustomerTable.getSelectionModel().getSelectedIndex();

    }

    public void searchCustermer(ActionEvent actionEvent) {
    }

    public boolean CheakId(String id) throws SQLException, ClassNotFoundException {
        conn = (Connection) DbConnecter.conn();
        PreparedStatement ps1 =  conn.prepareStatement("SELECT CuId  FROM customerInfo");
        ResultSet r = ps1.executeQuery();
        //String ID = r.getString(1);
        while (r.next()){
            if(r.getString(1).equals(id)){
                return false;
            }
        }
        return true;
    }

    public void viewTable() throws SQLException, ClassNotFoundException {
        conn = (Connection) DbConnecter.conn();
        PreparedStatement ps1 =  conn.prepareStatement("SELECT*  FROM customerInfo");
        ResultSet r = ps1.executeQuery();
            while (r.next()){
                String ID = r.getString("CuId");
                String NAME = r.getString("CuName");
                String ADDRESS = r.getString("CuAddress");
                int TEL = Integer.parseInt(r.getString("CuTel"));
                Customer c = new Customer(ID,NAME,ADDRESS,TEL);
               // CustomerTable.removeAll();
                CustomerTable.getItems().add(c);

            }

    }
}
