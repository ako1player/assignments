package model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
  private StringProperty password;
    private StringProperty username;
    private StringProperty name;
    private StringProperty address;
    private StringProperty city;
    private StringProperty state;
    private StringProperty zip;
    private StringProperty latitude;
    private StringProperty longitude;
    private StringProperty phoneNo;
    private StringProperty photo;

    public User() {
       this.username = new SimpleStringProperty("");
       this.password = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty("");
        this.longitude = new SimpleStringProperty("");
        this.phoneNo = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");

    }

    public User(String username, String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.latitude = new SimpleStringProperty("");
        this.longitude = new SimpleStringProperty("");
        this.phoneNo = new SimpleStringProperty("");
        this.photo = new SimpleStringProperty("");

    }
    public User(String password, String username, String name, String streetAddress, String city, String state, String zip, String latitude, String longitude, String phoneNo, String photo) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(streetAddress);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.photo = new SimpleStringProperty(photo);

    }


    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public StringProperty stateProperty() {
        return state;
    }

    public String getZip() {
        return zip.get();
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public StringProperty zipProperty() {
        return zip;
    }

    public String getLatitude() {
        return latitude.get();
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }

    public StringProperty latitudeProperty() {
        return latitude;
    }

    public String getLongitude() {
        return longitude.get();
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    public StringProperty phoneNoProperty() {
        return phoneNo;
    }

    public String getPhoto() {
        return photo.get();
    }

    public void setPhoto(String photo) {
        this.photo.set(photo);
    }

    public StringProperty photoProperty() {
        return photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password=" + password +
                ", name=" + name +
                ", address=" + address +
                ", city=" + city +
                ", state=" + state +
                ", zip=" + zip +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", phoneNo=" + phoneNo +
                ", photo=" + photo +
                '}';
    }

    @Override
    public int compareTo(User o) {
        // resource: http://www.java2s.com/Code/Java/Collections-Data-Structure/Sortonmanymorethanonefields.htm
        int compare = this.latitude.get().compareTo(o.getLatitude());
        return (compare == 0) ? this.longitude.get().compareTo(o.getLongitude()) : compare;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

  /*public String getUsername() {
        return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
*/
}

