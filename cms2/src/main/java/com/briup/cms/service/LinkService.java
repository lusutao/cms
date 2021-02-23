package com.briup.cms.service;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Link;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletResponse;

public interface LinkService {
    //分页获取所有链接
    Page<Link> findAll(Integer pageNum, Integer pageSize, HttpServletResponse response)throws ServiceException;
    //新增链接
    String save(Link link)throws ServiceException;
    //根据id查询链接
    Link  findById(Integer id)throws ServiceException;
    //根据id查询到的链接进行修改链接
    String update(Link link)throws ServiceException;
    //删除链接
    void delete(Integer id)throws ServiceException;
//    根据id分页获取所有链接
//    Page<Comment> findAllByArticleId(Long articleId,Integer pageNum, Integer pageSize)throws ServiceException;


}
