package com.udaan.sample.utils.dto.response;

import java.io.Serializable;

public class UserStatusUpdateResponse implements Serializable{
    
    private boolean updated;

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
    
    
}
