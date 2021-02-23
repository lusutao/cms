//package com.briup.cms.web.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.briup.cms.bean.User;
//import com.briup.cms.service.UserService;
//import com.briup.cms.util.JwtUtil;
//import com.briup.cms.util.Result;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//
//@Api(tags = "用户管理模块")
//@RestController
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//
//	@ApiOperation(value = "新增用户",notes = "新增用户，需要json格式的字符串")
//	@PostMapping("/user")
//	public Result regiser(@RequestBody User user) {
//
//		System.out.println(user);
//
//		userService.saveOrUpdateUser(user);
//
//		return Result.success(user);
//	}
//
//
//	@ApiOperation(value = "验证测试",notes = "添加JWT后，测试指定接口是否需要验证")
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",required = true,paramType = "query",defaultValue = "tom"),
//	})
//	@GetMapping("/auth/test")
//	public Result test(String username) {
//
//		return Result.success("hello! "+username);
//	}
//
//	/**
//	 * 注意，
//	 * 使用@ApiOperation(consumes = "application/x-www-form-urlencoded")来指定swagger中，把参数以什么形式进行传递
//	 * 如果这里不指定，那么它或默认使用application/json
//	 * 一定要观察swagger中显示执行的CURL命令中指定的请求头信息
//	 */
//	@ApiOperation(value = "用户登录",notes = "登录后，返回JWT的token值",consumes = "application/x-www-form-urlencoded")
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",required = true,paramType = "form",defaultValue = "tom"),
//        @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true,paramType = "form",defaultValue = "123456"),
//	})
//	@PostMapping(value="/login",consumes = "application/x-www-form-urlencoded")
//	public Result login(@RequestParam("username")String username,@RequestParam("password")String password) {
//
//		User user = userService.login(username, password);
//
//		Map<String, Object> info = new HashMap<String, Object>();
//		info.put("username", user.getUsername());
//		info.put("realname", user.getRealname());
//		//签发JWT的token
//		String token = JwtUtil.sign(Long.toString(user.getId()), info);
//
//		return Result.success("token: "+token);
//	}
//
//
//}
