package com.block.userblock.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserBlock{
	@Id
	private long id;
	//private String status;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private List<BlockedUser> userStatus;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdDate;

}
