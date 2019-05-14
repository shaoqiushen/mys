package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

@Data
public class SmallProgramResponse {
	private Integer status;
	private String msg;
	private SmallProgramUserInfo data;
}
