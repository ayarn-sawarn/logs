package com.block.userblock.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockedUser {
	 private long bid;
	 private String status;
	 @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	 private Date statusDate;
}
