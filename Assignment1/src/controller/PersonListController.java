package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.User;
import view.PersonGUIView;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonListController {
    @FXML
    private TextField searchKey;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> addressColumn;
    @FXML
    private TableColumn<User, String> cityColumn;
    @FXML
    private TableColumn<User, String> stateColumn;
    @FXML
    private TableColumn<User, String> zipColumn;
    @FXML
    private TableColumn<User, String> latitudeColumn;
    @FXML
    private TableColumn<User, String> longitudeColumn;
    @FXML
    private TableColumn<User, String> phoneNoColumn;
    @FXML
    private TableColumn<User, String> photoColumn;

    private PersonGUIView personApp;
   @FXML
   public void initialize() {
       nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
       addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
       cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
       stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
       zipColumn.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
       latitudeColumn.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
       longitudeColumn.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
       phoneNoColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
       photoColumn.setCellValueFactory(cellData -> cellData.getValue().photoProperty());
    }

    public void setPersonApp(PersonGUIView personApp){
       this.personApp = personApp;
       userTable.setItems(personApp.getUserData());
    }

    public void handleEnterPress(KeyEvent event){
        String latitude = "";
        String longitude = "";
        String key="";
        boolean coordinate = true;
        User userKey;
        ObservableList<User> searchUserResultTable = FXCollections.observableArrayList();

        if (event.getCode() == KeyCode.ENTER) {
            key = searchKey.getText();

            if (key.equals("")) {
                userTable.setItems(personApp.getUserData());
            }
            //if coordinate
            if (coordinate) {
                latitude = key.split(",")[0];
                longitude = key.split(",")[1];
                System.out.println(latitude + " " + longitude);
                userKey = new User(latitude, longitude);
                if (personApp.getUserBST().contains(userKey)) {
                    //create the new observable list and add the result to this list
                    searchUserResultTable.add(personApp.getUserBST().get(userKey));

                    userTable.setItems(searchUserResultTable);
                } else {

                    searchUserResultTable.clear();


                    userTable.setItems(searchUserResultTable);
                }
            }


        }
    }

}

