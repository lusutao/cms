package com.briup.cms.dao;

import com.briup.cms.bean.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentDao extends JpaRepository<Comment, Long> {
	
	Page<Comment> findByArticleId(Long id,Pageable pageable);
}
