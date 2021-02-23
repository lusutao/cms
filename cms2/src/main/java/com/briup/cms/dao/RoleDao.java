package com.briup.cms.dao;

import com.briup.cms.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long>{
	public Role findByName(String name);
}
