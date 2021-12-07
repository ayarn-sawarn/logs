package com.block.userblock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.block.userblock.entity.UserBlock;
import com.block.userblock.service.UserService;

@RestController
public class UserControllerBlock {
	
	@Autowired
	private UserService userService;
	@PostMapping("/users")
	public UserBlock createUser(@RequestBody UserBlock user) {
		return userService.createUser(user);
	}
	@GetMapping("/users")
	public ResponseEntity<List<UserBlock>> getAllUser(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	
	@GetMapping("/users/{id}")
	public Optional<UserBlock> getUserById(@PathVariable("id") long id) {
		return Optional.of(userService.getUserById(id));
	}
	
	@PutMapping("/users/block")
	public UserBlock blockUser(@RequestParam Long uId ,@RequestParam Long id) {
		return userService.blockUser(uId, id);
	}
	@PutMapping("/user/unblock")
	public UserBlock unblock(@RequestParam Long uId, @RequestParam Long id) {
		return userService.unblock(uId,id);
	}
}
