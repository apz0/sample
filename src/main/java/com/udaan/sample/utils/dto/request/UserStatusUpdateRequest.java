package com.udaan.sample.utils.dto.request;

import com.udaan.sample.model.ResultType;

public class UserStatusUpdateRequest {
    
    private Integer userId;
    private Integer adminId;
    private ResultType result;
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getAdminId() {
        return adminId;
    }
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public ResultType getResult() {
        return result;
    }
    public void setResult(ResultType result) {
        this.result = result;
    }

    
}
