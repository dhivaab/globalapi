package com.blueocean.globalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueocean.globalapi.model.User;
import com.blueocean.globalapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;

	public List<User> getUsers() {
		return userrepo.getAllUsers();
	}

	public User getUserbyId(int id) {
		return userrepo.getUser(id);
	}

	public User updateUser(User user) {
		return userrepo.updateUser(user);
	}

	public User createUser(User user) {
		return userrepo.createUser(user);
	}

	public void deleteUser(int id) {
		userrepo.deleteuser(id);
	}
}
