package com.blueocean.globalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.globalapi.model.User;
import com.blueocean.globalapi.service.UserService;

@RestController
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping(path = "/user")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			userservice.createUser(user);
			return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(path = "/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		try {
			userservice.deleteUser(id);
			return new ResponseEntity<String>("user deleted successfully", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/user/{id}")
	ResponseEntity<?> updateUser(@PathVariable("id") int id) {
		try {
			User user = userservice.getUserbyId(id);
			User userobj = userservice.updateUser(user);
			return new ResponseEntity<User>(userobj, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("user not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/user/{id}")
	ResponseEntity<?> getUserbyId(@PathVariable("id") int id) {
		try {
			User user = userservice.getUserbyId(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user")
	ResponseEntity<?> getAllusers() {
		List<User> users = userservice.getUsers();
		if (users != null) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("users not available", HttpStatus.OK);
		}
	}
}
