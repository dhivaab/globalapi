package com.blueocean.globalapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blueocean.globalapi.model.User;

@Repository
public class UserRepository {
	public List<User> users;

	public UserRepository() {
		users = new ArrayList<User>();

	}

	public List<User> getAllUsers() {
		users.add(new User(1, "balamurugan", "alagumalai", "kvs", "kamaraj"));
		users.add(new User(2, "rajavenkatesh", "p", "kamak", "kamaraj"));
		users.add(new User(3, "kundavai", "tadi", "johndewey", "cit"));
		users.add(new User(4, "lalithambigai", "g", "psc", "kamaraj"));
		users.add(new User(5, "ramya", "Lenin", "chinamaya", "kamaraj"));
		users.add(new User(6, "chinna", "r", "pgs", "psg"));
		return users;

	}

	public User getUser(int id) {
		User user = users.stream().filter(e -> e.getId() == id).findAny().orElse(null);
		return user;
	}

	public User createUser(User user) {
		users.add(user);
		return user;
	}

	public User updateUser(User user) {
		User newuser = users.stream().filter(e -> e.getId() == user.getId()).findAny().orElse(null);
		users.remove(newuser);
		users.add(user);
		return user;
	}

	public void deleteuser(int id) {
		users.remove(id);
	}
}
