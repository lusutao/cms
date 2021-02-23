package com.briup.cms.dao;

import com.briup.cms.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDao extends JpaRepository<Category, Long> {
	
}
