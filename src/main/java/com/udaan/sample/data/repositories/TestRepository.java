package com.udaan.sample.data.repositories;

import com.udaan.sample.data.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer>{
    
}
