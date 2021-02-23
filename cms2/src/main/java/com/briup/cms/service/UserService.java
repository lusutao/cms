package com.briup.cms.service;

import com.briup.cms.bean.User;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
	//分页获取所有用户信息
	Page<User> getAll(Integer pageNum,Integer pageSize)throws ServiceException;
	//新增用户信息或者更新学生信息
	void saveOrUpdateUser(User user)throws ServiceException;
	//批量删除用户信息
	void deleteUserInBatch(List<Long> ids)throws ServiceException;
	
	//修改用户的状态
	void updateUserStatus(Long id,String status)throws ServiceException;
	
	//登录
	User login(User user, HttpServletResponse httpServletResponse)throws ServiceException;
	//根据用户名获取用户信息
	User findUserByUsername(String username)throws ServiceException;
	
}
