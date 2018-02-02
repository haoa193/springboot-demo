package com.haoa193.springbootdemo.vo;

import io.gd.generator.annotation.Field;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserLogListVo implements Serializable {
	/* 原生 */
	@Field(label = "id")
	private String id;
	@Field(label = "用户id")
	private String userId;
	@Field(label = "项目id")
	private String projectId;
	@Field(label = "操作")
	private String operation;
	@Field(label = "操作者id")
	private String operatorId;
	@Field(label = "操作时间")
	private Date operatedTime;
	@Field(label = "备注")
	private String remark;

	/* 扩展 */

}