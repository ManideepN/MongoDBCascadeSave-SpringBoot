package com.chc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chc.model.Address;
import com.chc.model.Users;
import com.chc.repository.AddressRepository;
import com.chc.repository.UsersRepository;


@RestController
@RequestMapping(value = "/admin")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllusers() {
		List<Users> usersInfoList = usersRepository.findAll();
		return new ResponseEntity<List<Users>>(usersInfoList, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/user1", method = RequestMethod.GET)
//	public ResponseEntity<Optional<Users>> getAlluser1(@RequestBody Users users) {
//		Optional<Users> usersInfo= usersRepository.findById(users.getId());
//		return new ResponseEntity<Optional<Users>>(usersInfo, HttpStatus.OK);
//	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public ResponseEntity<List<Address>> getAllmodules() {
		List<Address> addressList = addressRepository.findAll();
		return new ResponseEntity<List<Address>>(addressList, HttpStatus.OK);
	}

	@RequestMapping(value = "/addUsers", method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<Users> addUser(@RequestBody Users users) {
//		Users.setUserN(Users.getName().toUpperCase());
		Users info = usersRepository.insert(users);
		System.out.println("***saved User: "+info);
		return new ResponseEntity<Users>(info, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<Users> updateUser(@RequestBody Users Users) {
//		Users.setUserN(Users.getName().toUpperCase());
		Users info = usersRepository.save(Users);
		System.out.println("***updated User: "+info);
		return new ResponseEntity<Users>(info, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUser(@RequestBody Users User) {
		usersRepository.delete(User);
		return new ResponseEntity<Users>(User, HttpStatus.NO_CONTENT);
	}

//	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = { "application/json" })
//	public ResponseEntity<Integer> updateUser(@RequestBody Users Users) {
//		Integer val = userRepository.save(Users);
//		if (val == 1) {
//			Users Users2 = userRepository.findOne(Users.getUserId());
//			Users2.setModuleTypes(Users.getModuleTypes());
//			userRepository.save(Users2);
//		}
//		return new ResponseEntity<Integer>(val, HttpStatus.OK);
//	}

}
