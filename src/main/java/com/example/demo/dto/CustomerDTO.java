package com.example.demo.dto;

public class CustomerDTO {
	private Long CustomerID;
    private String Username;
    private String Password;
    private String RepeatPassword;
    private String Fullname;
    private String Address;
    private String City;

//    public CustomerDTO(String Username,String Password,String RepeatPassword,String Fullname,String Address,String City) {
//    	this.Username=Username;
//    	this.Password=Password;
//    	this.RepeatPassword=RepeatPassword;
//    	this.Fullname=Fullname;
//    	this.Address=Address;
//    	this.City=City;
//    }
    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long customerID) {
        CustomerID = customerID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    
    public String getRepeatPassword() {
    	return RepeatPassword;
    }
    public void setRepeatPassword(String repeatpassword) {
    	RepeatPassword = repeatpassword;
    }
    
    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
    
    
}
