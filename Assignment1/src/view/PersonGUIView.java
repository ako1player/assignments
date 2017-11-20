package view;

import controller.PersonListController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ReadExcel;
import model.User;
import utils.BinarySearchTree;

import java.io.IOException;
import java.util.List;

public class PersonGUIView {
    private static Stage personListStage = new Stage();
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phoneNumber;
    private String photo;
    private String username;
    private String password;
    private ObservableList<User> userData = FXCollections.observableArrayList();
    private BinarySearchTree<User> userBST;
    private BorderPane rootLayout;

    public PersonGUIView() throws IOException {
        loadPerson();
        initRootLayout();
        showPersonView();
        personListStage.setTitle("Person list Page");
    }
    public BinarySearchTree<User> getUserBST(){
        return userBST;
    }

    private void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PersonGUIView.class.getResource("RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            personListStage.setScene(scene);
            personListStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void loadPerson() {
        userBST = new BinarySearchTree<User>();
        List userList = null;
        try {
            userList = ReadExcel.excelReader("Person List.xls");
        } catch (Exception e) {
            System.err.println("Problem reading PersonList.xls file");
            e.printStackTrace();
        }

        for (int i = 0; i < userList.size(); i++) {
            List record = (List) userList.get(i);
            name = String.valueOf(record.get(0));
            address = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            phoneNumber = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));
            User user = new User(name, address, city, state, zip, latitude, longitude, phoneNumber, photo,username,password);
            userBST.add(user);
            userData.add(user);
        }
    }
    public void showPersonView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PersonGUIView.class.getResource("PersonGUI.fxml"));
            SplitPane personOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PersonListController controller = loader.getController();
            controller.setPersonApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<User> getUserData(){
        return userData;
    }

    public void setUserData(ObservableList<User> userData){
        this.userData = userData;
    }
}
