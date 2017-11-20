package view;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import controller.SignupController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserList;
import model.UserIO;
import view.PersonGUIView;


import java.awt.event.ActionEvent;
import java.io.IOException;

import static javafx.application.Application.launch;

public class LoginJavaFXView{
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    boolean exist=false;

    public void signin() throws IOException{
        for(int i=0; i<UserList.getUserList().size(); i++) {

            if (username.getText().equals(UserList.getUserList().get(i).getUsername())) {
                System.out.println("Welcome " +username.getText());
                try {
                    new PersonGUIView();
                } catch (IOException e) {
                    System.err.println("Error opening hospital list view!");
                    e.printStackTrace();
                }
                exist = true;
            }
        }
    }

    public void openSignupView() throws IOException {
        System.out.println("Open signup view");
        new SignupController();
    }

    public void displaySignupView() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpJavaFX.fxml"));
        primaryStage.setTitle("Signup Page");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
