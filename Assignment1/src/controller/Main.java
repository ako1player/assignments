package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.UserIO;
import model.UserList;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadUserList();
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginJavaFX.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public void loadUserList() {
        try {
            UserList.setUserList((ArrayList<User>) UserIO.readUsers());

        } catch (IOException e) {
            System.err.print("Fail to open/read UserDB.dat file.");
        } catch (ClassNotFoundException e) {
            System.err.print("Fail reading and casting the UserDB dues to User class issue!");
        }
    }
}