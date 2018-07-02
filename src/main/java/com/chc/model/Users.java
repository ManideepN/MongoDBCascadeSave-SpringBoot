package com.chc.model;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.chc.model.mongoConfig.CascadeSave;

@Document(collection = "Users")
public class Users {

	@Id
	// private ObjectId id;
	private String id;

	private String contact;

	@NotEmpty(message = "user_name can not be null")
	@Field("dob")
	private String dob;

	@Field("name")
	private String name;

	@DBRef
	@CascadeSave
	private Address address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", contact=" + contact + ", dob=" + dob + ", name=" + name + ", address=" + address
				+ "]";
	}

}
