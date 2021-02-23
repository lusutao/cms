package com.briup.cms.web.controller;

import com.briup.cms.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试模块")
@RestController
public class HelloController {
	
	@ApiOperation(value = "hello测试",notes = "第一个swagger测试程序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",dataType = "String",required = true,paramType = "query"),
    })
	@GetMapping("/hello")
	public Result hello(String name) {
		if("tom".equals(name)) {
			throw new RuntimeException("test...");
		}
		return Result.success("hello world!"+name);
	}
	
}
