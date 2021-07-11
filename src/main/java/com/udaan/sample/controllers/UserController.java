package com.udaan.sample.controllers;

import com.udaan.sample.data.entities.Users;
import com.udaan.sample.data.entities.Zones;
import com.udaan.sample.data.repositories.UserRepository;
import com.udaan.sample.data.repositories.ZonesRepository;
import com.udaan.sample.utils.bridges.ZoneUtil;
import com.udaan.sample.utils.dto.request.AdminCreationRequest;
import com.udaan.sample.utils.dto.request.UserCreationRequest;
import com.udaan.sample.utils.dto.request.UserStatusUpdateRequest;
import com.udaan.sample.utils.dto.response.AdminCreationResponse;
import com.udaan.sample.utils.dto.response.UserCreationResponse;
import com.udaan.sample.utils.dto.response.UserStatusUpdateResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ZonesRepository zonesRepository;
    
    @PostMapping(path = "/registerUser")
	public @ResponseBody UserCreationResponse registerUser(@RequestBody UserCreationRequest request) {
       
        Users user = saveUser(request, false);
        

        UserCreationResponse response = new UserCreationResponse();

        response.setUserId(user.getUserId());

		return response;
	}

    @PostMapping(path = "/registerAdmin")
    public @ResponseBody AdminCreationResponse registerUser(@RequestBody AdminCreationRequest request) {

        Users admin = saveAdmin(request);

        AdminCreationResponse response = new AdminCreationResponse();

        response.setAdminId(admin.getUserId());

        return response;
    }

    @PostMapping(path = "/updateUserStatus")
    public @ResponseBody UserStatusUpdateResponse updateUserStatus(@RequestBody UserStatusUpdateRequest request) {
       
        UserStatusUpdateResponse response = new UserStatusUpdateResponse();

        try {
            userRepository.updateUserStatus(request.getResult().name(), request.getUserId());
            response.setUpdated(true);
        } catch(Exception error) {
            System.out.println(error);
            response.setUpdated(false);
        }

        return response;
    }


    private Users saveAdmin(AdminCreationRequest request) {
        return saveUser(request, true);
    }

    private Users saveUser(UserCreationRequest request, boolean isAdmin) {
        Users user = new Users();

        user.setName(request.getName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setZone(getZoneByPinCode(request.getPinCode()));
        user.setAdmin(isAdmin);

        user = userRepository.save(user);

        return user;
    }


    private Zones getZoneByPinCode(Integer pinCode) {

        Zones zone = zonesRepository.getZonesByPinCodes(pinCode);

        if (zone == null) {
            zone = new Zones();
            zone.setPinCode(pinCode);
            zone = zonesRepository.save(zone);
        }

        return zone;
    }

}
