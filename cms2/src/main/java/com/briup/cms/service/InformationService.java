package com.briup.cms.service;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Information;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

public interface InformationService {
    //分页获取所有栏目
    Page<Information> findAll(Integer pageNum, Integer pageSize)throws ServiceException;
    //根据id删除
    void delete(Integer id)throws ServiceException;
    //新增栏目1
    String save(Information information,Integer id)throws ServiceException;
    //新增栏目2
    String save2(Information information)throws ServiceException;
    //通过id查询信息
    Information findById(Integer id) throws ServiceException;
}


