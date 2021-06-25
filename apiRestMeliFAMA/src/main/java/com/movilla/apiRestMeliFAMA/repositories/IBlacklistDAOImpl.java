package com.movilla.apiRestMeliFAMA.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.movilla.apiRestMeliFAMA.models.BlacklistDTO;

public abstract class IBlacklistDAOImpl implements IBlacklistDAO {

	@Autowired
	private Environment env;

	private String uriDB = env.getProperty("spring.data.mongodb.uri");
	private String dataBase = env.getProperty("spring.data.mongodb.database");
	private String coleccionBlackList = env.getProperty("blackList.collection.mongodb");
	private MongoClient mongoClient = MongoClients.create(uriDB);
	private MongoDatabase database = mongoClient.getDatabase(dataBase);
	private MongoCollection<Document> collection = database.getCollection(coleccionBlackList);

	@Override
	public void deleteOneByIp(String direccionIp) {
		Document delete = new Document("ip", direccionIp);
		collection.deleteOne(delete);
	}

	@Override
	public BlacklistDTO queryOneByIp(String direccionIp) {
		BlacklistDTO blacklistDTO = new BlacklistDTO();
		Document query = new Document("ip", direccionIp);			
		Document result = collection.find(query).iterator().next();
		blacklistDTO.set_id(result.getObjectId("_id").toString());
		blacklistDTO.setIp(result.getString("ip"));
		blacklistDTO.setDate_create(result.getDate("date_create"));
		return blacklistDTO;
	}

}
