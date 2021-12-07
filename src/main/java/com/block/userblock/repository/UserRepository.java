package com.block.userblock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.block.userblock.entity.UserBlock;
@Repository
public interface UserRepository  extends MongoRepository<UserBlock, Long>{

}
