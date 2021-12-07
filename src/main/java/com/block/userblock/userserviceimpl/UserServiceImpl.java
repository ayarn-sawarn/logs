package com.block.userblock.userserviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.block.userblock.entity.BlockedUser;
import com.block.userblock.entity.UserBlock;
import com.block.userblock.repository.UserRepository;
import com.block.userblock.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserBlock createUser(UserBlock user) {
		Date created = new Date();
		user.setCreatedDate(created);
		UserBlock save = userRepo.save(user);
		return save;

	}

	@Override
	public List<UserBlock> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public UserBlock blockUser(long uid, long id) {
		Date created = new Date();
		BlockedUser buser = new BlockedUser();
		UserBlock updateduser = null;
		buser.setBid(id);
		buser.setStatus("Blocked");
		buser.setStatusDate(created);
		List<BlockedUser> li = new ArrayList<>();
		li.add(buser);
		Optional<UserBlock> user = this.userRepo.findById(uid);
		if (user.isPresent()) {
			UserBlock oldUser = user.get();
			oldUser.setUserStatus(li);
			updateduser = this.userRepo.save(oldUser);
		}

		return updateduser;
	}

	@Override
	public UserBlock unblock(long uid, long id) {
		Date created = new Date();
		BlockedUser buser = new BlockedUser();
		UserBlock updateduser = null;
		buser.setBid(id);
		buser.setStatus("unblocked");
		buser.setStatusDate(created);
		List<BlockedUser> li = new ArrayList<>();
		li.add(buser);
		
		Optional<UserBlock> user = this.userRepo.findById(uid);
		if (user.isPresent()) {
			UserBlock oldUser = user.get();
			//getting list of old user
			List<BlockedUser> old = oldUser.getUserStatus();
			li.addAll(old);
			oldUser.setUserStatus(li);
			updateduser = this.userRepo.save(oldUser);
			
		}
		return updateduser;
	}

	// testing purpose
	public UserBlock getUserById(long id) {
		Optional<UserBlock> u = this.userRepo.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {

		}
		return u.get();
	}

}
