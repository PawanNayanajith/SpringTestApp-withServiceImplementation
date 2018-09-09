package com.sgic.myleave.service;


import com.sgic.myleave.entity.User;

import java.util.List;

public interface UserService {
	boolean saveUser(User user);
	boolean updateUser(User user, int id);
	List<User> getAllUsers();
	boolean deleteUser(int id);
}
