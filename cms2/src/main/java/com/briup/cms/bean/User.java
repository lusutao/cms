package com.briup.cms.bean;

import com.briup.cms.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户
 */
@Entity
@Table(name="cms_user")
@Data
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 编号（主键）
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	

	
	/**
	 * 真实姓名
	 */
	private String realname;
	
	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 生日
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	/**
	 * 注册时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date registerTime;

	/**
	 * 验证码
	 */
//	@ApiModelProperty()
	private String code;
//	/**
//	 * 账号是否可用
//	 */
//	Boolean enabled;
//
//	/**
//	 * 账号是否过期
//	 */
//	Boolean accountNonExpired;
//
//	/**
//	 * 密码是否过期
//	 */
//	Boolean credentialsNonExpired;
//
//	/**
//	 * 账号是否锁定
//	 */
//	boolean accountNonLocked;
//
//	/**
//	 * 用户权限列表
//	 */
//	Collection <? extends GrantedAuthority> authorities;




}
