package com.udaan.sample.data.repositories;

import com.udaan.sample.data.entities.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    
    @Query(value = "update Users SET result = ?1 where userId = ?2")
    public Users updateUserStatus(String status, Integer userId);
}
