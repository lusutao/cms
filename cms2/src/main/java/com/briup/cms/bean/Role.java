package com.briup.cms.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色
 */
@Entity
@Table(name="cms_role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号（主键）
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 角色名
	 */
	private String name;
	
	/**
	 * 角色描述信息
	 */
	private String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
