package com.briup.cms.service.impl;

import com.briup.cms.bean.User;
import com.briup.cms.dao.UserDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.UserService;
import com.briup.cms.util.CodeController;
import com.briup.cms.util.ResultCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Api(tags = "用户模块（暂只用log方法）")
@RequestMapping("user")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private CodeController codeController;

	@Override
	public Page<User> getAll(Integer pageNum, Integer pageSize) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public void saveOrUpdateUser(User user) throws ServiceException {
		String username = user.getUsername();
		if(username==null || "".equals(username.trim())) {
			throw new ServiceException(ResultCode.USER_NOT_EMPTY);
		}
		
		//用户名不能重复
		User userFromDB = userDao.findByUsername(user.getUsername());
		if(userFromDB!=null) {
			throw new ServiceException(ResultCode.USER_HAS_EXISTED);
		}
		
		userDao.save(user);
	}

	@Override
	public void deleteUserInBatch(List<Long> ids) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserStatus(Long id, String status) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@PostMapping("/login")
	public User login(@RequestBody User user1 , HttpServletResponse httpServletResponse, HttpServletRequest request) throws ServiceException {
//		httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
		System.out.println("开始登录");
		String username = user1.getUsername();
		String password = user1.getPassword();
		String userCode =user1.getCode();
		System.out.println("usermod="+userCode);
		String captcha = (String) request.getSession().getAttribute("captcha");
//		String captcha = codeController.getKaptchaImage(request,httpServletResponse);
		System.out.println("captcha="+captcha);
		if (userCode==null || !userCode.equals(captcha)){
			System.out.println("验证码错误");
			throw new ServiceException(ResultCode.USER_LOGIN_ERROR);
		}
		User user = userDao.findByUsername(username);
		
		if(user==null || !user.getPassword().equals(password)) {
			System.out.println("账号密码错误");
			throw new ServiceException(ResultCode.USER_LOGIN_ERROR);
		}
		System.out.println("登录成功");
		return user;
	}

	@Override
	@GetMapping("/findUserByUsername")
	public User findUserByUsername(String username) throws ServiceException {
		// TODO Auto-generated method stub
		User byUsername = userDao.findByUsername(username);
		return byUsername;
	}


}
