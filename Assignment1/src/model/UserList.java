package model;

import java.util.ArrayList;

public class UserList {
   private static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<User> getUserList() {
        return userList;
    }
    public static void setUserList(ArrayList<User> userList) {
        UserList.userList = userList;


    }
}
