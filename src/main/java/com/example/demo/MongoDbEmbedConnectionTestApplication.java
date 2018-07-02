package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com"})
@EnableMongoRepositories(basePackages= {"com"})
public class MongoDbEmbedConnectionTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbEmbedConnectionTestApplication.class, args);
	}

	@Autowired
	  private MongoOperations mongoOperations;


//	@Before
//	  public void cleanCollections() {
//	      mongoOperations.dropCollection(Users.class);
//	      mongoOperations.dropCollection(Address.class);
//	  }
//	
	@Override
	public void run(String... args) throws Exception {
//		Users user = new Users();
//		user.setName("Manideep");
//		user.setDob("21-01-2001");
//		Address address= new Address();
//		address.setCity("Hyd");
//		address.setState("TG");
//		user.setAddress(address);
//		mongoOperations.save(user);
//		
//		System.out.println("***Saved.");
//		List<Users> users = mongoOperations.findAll(Users.class);
//		System.out.println("***Users:"+users.get(0));
//		
//		List<Address> addresses = mongoOperations.findAll(Address.class);
//		System.out.println("***Addresses:"+addresses.get(0));
	
	}


}
