package com.block.userblock.service;

import java.util.List;
import java.util.Optional;

import com.block.userblock.entity.UserBlock;

public interface UserService {
	   public UserBlock createUser(UserBlock user);
	   public List<UserBlock> getAllUsers();
	   public UserBlock blockUser(long uid, long id);
	   public UserBlock unblock(long uid, long id);
	   public UserBlock getUserById(long id);
	   
}
