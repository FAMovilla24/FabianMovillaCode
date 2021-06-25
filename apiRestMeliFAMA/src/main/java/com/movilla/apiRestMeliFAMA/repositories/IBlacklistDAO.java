package com.movilla.apiRestMeliFAMA.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movilla.apiRestMeliFAMA.models.BlacklistDTO;

@Repository
public interface IBlacklistDAO extends MongoRepository<BlacklistDTO, String> {
	
    void deleteOneByIp(String direccionIp);
	
	BlacklistDTO queryOneByIp(String direccionIp);	

}
