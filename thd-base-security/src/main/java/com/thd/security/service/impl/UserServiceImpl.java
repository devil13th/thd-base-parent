package com.thd.security.service.impl;

import javax.annotation.Resource;

import com.thd.security.service.UserService;
import com.thd.util.dao.JdbcDao;
import com.thd.util.dao.PubDao;
import com.thd.util.service.PubServiceImpl;

public class UserServiceImpl extends PubServiceImpl implements UserService {
	@Resource 
	private PubDao pubDao;
	@Resource
	private JdbcDao jdbcDao;
	
	
}
