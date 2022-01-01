package main;

public class PhoneBookItem {

    private String name;
    private String address;
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("NAME: %s\n EMAIL: %s\n ADDRESS: %s" , getName(), getEmail(), getAddress());
    }
}