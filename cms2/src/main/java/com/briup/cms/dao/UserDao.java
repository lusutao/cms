package com.briup.cms.dao;

import com.briup.cms.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	public User findByUsername(String name);
}
