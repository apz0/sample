package com.udaan.sample.utils.dto.request;

public class AdminCreationRequest extends UserCreationRequest{
    
    private boolean admin = true;

    public boolean isAdmin() {
        return admin;
    }
    
}
