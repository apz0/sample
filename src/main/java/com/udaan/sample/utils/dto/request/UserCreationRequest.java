package com.udaan.sample.utils.dto.request;

import java.io.Serializable;

public class UserCreationRequest implements Serializable{
    
    private String name;
    private String phoneNumber;
    private Integer pinCode;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    
}
