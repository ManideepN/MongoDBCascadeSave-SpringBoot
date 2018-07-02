package com.chc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chc.model.Address;

//@RepositoryRestResource(collectionResourceRel = "Address", path = "Address")
public interface AddressRepository extends MongoRepository<Address, String>{

}
