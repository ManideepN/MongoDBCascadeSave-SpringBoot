package com.chc.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chc.model.Users;

//@RepositoryRestResource(collectionResourceRel = "Users", path = "Users")
public interface UsersRepository extends MongoRepository<Users, String>{

}
