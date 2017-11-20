package test;

import model.ReadExcel;
import model.User;
import org.junit.Test;
import utils.BinarySearchTree;

import java.util.List;



public class ReadExcelTest {
    private String name;
    private String zip;
    private String state;
    private String photo;
    private String city;
    private String longitude;
    private String latitude;
    private String address;
    private String country;

    @Test
    public void excelReader() throws Exception {

        BinarySearchTree<User> userBST = new BinarySearchTree<User>();
        List userList = ReadExcel.excelReader("Person List.xls");
        //ReadExcelFile.showExcelData(hospitalList);
        System.out.println(userList.size());
        for (int i = 0; i < userList.size(); i++) {
            List record = (List) userList.get(i);
            System.out.println(record);
            name = String.valueOf(record.get(0));
            address = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            country = String.valueOf(record.get(4));
            zip = String.valueOf(record.get(5));
            latitude = String.valueOf(record.get(6));
            longitude = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));

        }


    }

}



