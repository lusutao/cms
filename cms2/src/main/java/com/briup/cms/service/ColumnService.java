package com.briup.cms.service;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Column;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ColumnService {
    //不分页获取所有栏目
    List<Column> findAll() throws ServiceException;
    //分页获取所有栏目
    Page<Column> findAll(Integer pageNum, Integer pageSize, HttpServletResponse response)throws ServiceException;
    //新增栏目
    String save(Column column)throws ServiceException;
    //根据id查询栏目
    Column  findById(Integer id)throws ServiceException;
    //根据id查询到的栏目进行修改栏目
    String update(Column column)throws ServiceException;
    //删除栏目
    void delete(Integer id)throws ServiceException;
//    根据id分页获取所有栏目
//    Page<Comment> findAllByArticleId(Long articleId,Integer pageNum, Integer pageSize)throws ServiceException;


}
