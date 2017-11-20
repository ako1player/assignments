package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.Window;
import model.*;
import view.PersonGUIView;
import view.SignupView;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static java.lang.System.err;


public class SignupController{
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField email;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField cpassword;
    @FXML
    TextField dob;
    @FXML
    RadioButton male;
    @FXML
    RadioButton female;
    @FXML
    TextField phone;
    @FXML
    TextField country;
    @FXML
    TextField zip;
    @FXML
    TextField ssn;
    @FXML
    Label fnLabel, unLabel, pwLabel;

    public void createAccount() {
        if(password.getText().equals(cpassword.getText())) {
            User user = new User(username.getText(),password.getText());
            UserList.getUserList().add(user);
            try {
                UserIO.writeUsers(UserList.getUserList());
            } catch (IOException e) {
                System.err.println("Cannot write UserDB to binary file!");
                e.printStackTrace();
            }
        }
        System.out.println(UserList.getUserList());
    }

    public void browse() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(SignupView.getSignupStage());
        System.out.println(selectedFile.getPath());

    }
}