package com.sgic.myleave.service;

import com.sgic.myleave.entity.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users = new ArrayList<>();

	@Override
	public boolean saveUser(User user) {
		users.add(user);
		return true;
	}

	@Override
	public boolean updateUser(User user, int id) {
		for (User existingUser : users) {
			if (existingUser.getEmpId() == id) {
				existingUser.setDesignation(user.getDesignation());
				existingUser.setName(user.getName());
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public boolean deleteUser(int id) {
		for (User existingUser : users) {
			if (existingUser.getEmpId() == id) {
				// users.remove(users.indexOf(existingUser));
				users.remove(existingUser);
				return true;
			}
		}
		return false;
	}

}
