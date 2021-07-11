package com.udaan.sample.data.repositories;

import com.udaan.sample.data.entities.Zones;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZonesRepository extends CrudRepository<Zones, Integer>{
    
    @Query(value = "select * from zones where pin_code = ?1", nativeQuery = true)
    public Zones getZonesByPinCodes(Integer pinCode);
}
