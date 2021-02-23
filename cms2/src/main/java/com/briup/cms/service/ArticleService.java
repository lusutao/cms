package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Comment;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {
	//发布资讯或者编辑资讯
	void saveOrUpdateArticle(Article article)throws ServiceException;
	//分页获取所有资讯
	//pageNum:页码，pageSize：一页显示多少条数据
	Page<Article> findAll(Integer pageNum,Integer pageSize)throws ServiceException;
	//批量删除资讯
	void deleteArticleInBatch(List<Long> ids)throws ServiceException;
	//管理员审核资讯
	void updateArticleStatus(Long id,String status)throws ServiceException;

	//根据资讯id查找资讯的所有评论，并分页显示评论
	Page<Comment> findAllCommentsByArticleId(Long articleId,int pageNum,int pageSize)throws ServiceException;
}
