package com.samples.employee.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.samples.employee.config.MongoProperties.MongoNode;
import com.samples.employee.config.MongoProperties.MongoNodeCredential;

@Configuration
//@EnableMongoRepositories(basePackages = "com.samples.employee.repositories")
public class MongoConfig {

	@Autowired
	private MongoProperties mongoProperties;

	/*
	 * public MongoConfig(MongoProperties mongoProperties) { super();
	 * this.mongoProperties = mongoProperties; }
	 */

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {

		System.out.println("config message" + mongoProperties.getTestmessage());
		
		List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
		List<MongoNode> nodes = mongoProperties.getMongoNodes();

		for (MongoNode mongoNode : nodes) {
			serverAddressList.add(new ServerAddress(mongoNode.getHost(), mongoNode.getPort()));
		}

		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		List<MongoNodeCredential> mongoCredentials = mongoProperties.getMongoNodeCredentials();
		for (MongoNodeCredential mongoNodeCredential : mongoCredentials) {
			String password = mongoNodeCredential.getPassword();
			String username = mongoNodeCredential.getUsername();
			String authSource = mongoNodeCredential.getAuthSource();
			final MongoCredential credential = MongoCredential.createScramSha1Credential(username, authSource,
					password.toCharArray());
			credentialsList.add(credential);			
		}
		//FIXME validation
		return new MongoClient(serverAddressList);//, credentialsList);

	}

/*	@PostConstruct
	private void init() {

	}
*/
}
