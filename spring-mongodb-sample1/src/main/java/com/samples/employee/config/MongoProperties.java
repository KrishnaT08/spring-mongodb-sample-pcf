/**
 * 
 */
package com.samples.employee.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author KrishnaPC
 *
 */
@Component
@ConfigurationProperties(prefix = "mongodb")
public class MongoProperties {

	private List<MongoNode> mongoNodes = new ArrayList<MongoNode>();

	private List<MongoNodeCredential> mongoNodeCredentials = new ArrayList<MongoNodeCredential>();

	private String testmessage;
	
	
	
	/**
	 * @return the testmessage
	 */
	public String getTestmessage() {
		return testmessage;
	}

	/**
	 * @param testmessage the testmessage to set
	 */
	public void setTestmessage(String testmessage) {
		this.testmessage = testmessage;
	}

	public List<MongoNode> getMongoNodes() {
		return mongoNodes;
	}

	public void setMongoNodes(List<MongoNode> mongoNodes) {
		this.mongoNodes = mongoNodes;
	}

	public List<MongoNodeCredential> getMongoNodeCredentials() {
		return mongoNodeCredentials;
	}

	public void setMongoNodeCredentials(List<MongoNodeCredential> mongoNodeCredentials) {
		this.mongoNodeCredentials = mongoNodeCredentials;
	}

	public static class MongoNode {

		// @Value("${mongodb.host:localhost}")
		private String host;

		// @Value("${mongodb.port:27017}")
		private int port;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

	}

	public static class MongoNodeCredential {
		// @Value("${mongodb.username:admin}")
		private String username;

		// @Value("${mongodb.password:password}")
		private String password;

		// @Value("${mongodb.authdb:admin}")
		private String authSource;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAuthSource() {
			return authSource;
		}

		public void setAuthSource(String authSource) {
			this.authSource = authSource;
		}
	}

}
