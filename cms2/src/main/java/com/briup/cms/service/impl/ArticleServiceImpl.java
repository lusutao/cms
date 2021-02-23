package com.briup.cms.service.impl;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Comment;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("article")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Override
    public void saveOrUpdateArticle(Article article) throws ServiceException {

    }

    @Override
    @GetMapping("findAll/{pageNum}/{pageSize}")
    public Page<Article> findAll(Integer pageNum, Integer pageSize) throws ServiceException {
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return articleDao.findAll(pageable);
    }

    @Override
    public void deleteArticleInBatch(List<Long> ids) throws ServiceException {

    }

    @Override
    public void updateArticleStatus(Long id, String status) throws ServiceException {

    }

    @Override
    public Page<Comment> findAllCommentsByArticleId(Long articleId, int pageNum, int pageSize) throws ServiceException {
        return null;
    }
}
