package com.sgic.myleave.controller;

import com.sgic.myleave.service.UserService;
import com.sgic.myleave.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	List<User> users = new ArrayList<>();

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser() {
		ResponseEntity<List<User>> response = new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		return response;
	}

	@PostMapping("/users")
	public HttpStatus createUsers(@Valid @RequestBody User user) {
		boolean test = userService.saveUser(user);
		if (test) {
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@PutMapping("/users/{empId}")
	public HttpStatus editUsers(@RequestBody User user, @PathVariable("empId") int id) {
		boolean test = userService.updateUser(user, id);
		if (test) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@DeleteMapping("/users/{empId}")
	public HttpStatus deleteUsers(@PathVariable("empId") int id) {
		boolean test = userService.deleteUser(id);
		if (test) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
	}
}