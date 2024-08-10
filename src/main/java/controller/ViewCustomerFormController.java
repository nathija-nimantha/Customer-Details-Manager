package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        loadTable();
    }

    public TableView tblCustomer;
    @FXML
    private JFXButton btnRefresh;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    void btnRefreshOnAction(ActionEvent event) {
        loadTable();
    }

    private void loadTable() {
        ObservableList<Object> customerObserverbleList = FXCollections.observableArrayList();


        List<Customer> dbList = DBConnection.getInstance().getConnection();

        dbList.forEach(obj -> {
            customerObserverbleList.add(obj);
        });

        customerObserverbleList.add(new Customer("1", "Ahmed", "Cairo", 5000.0));
        customerObserverbleList.add(new Customer("2", "Mahmoud", "Alex", 7000.0));

        tblCustomer.setItems(customerObserverbleList);
    }
}
