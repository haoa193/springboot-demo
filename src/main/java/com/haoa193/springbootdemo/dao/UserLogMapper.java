package com.haoa193.springbootdemo.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.haoa193.springbootdemo.entity.usr.UserLog;
import com.haoa193.springbootdemo.model.query.UserLogQueryModel;


public interface UserLogMapper {

	int insert(UserLog userLog);

	int update(UserLog userLog);

	int merge(@Param("userLog") UserLog userLog, @Param("fields")String... fields);

	int delete(String id);

	UserLog findOne(String id);

	List<UserLog> findAll(UserLogQueryModel userLogQueryModel);

	long count(UserLogQueryModel userLogQueryModel);

}