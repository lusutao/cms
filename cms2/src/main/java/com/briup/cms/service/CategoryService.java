package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
	//分页获取所有分类
	Page<Category> findAll(Integer pageNum,Integer pageSize)throws ServiceException;
	//新增分类或者更新分类
	void saveOrUpdateCategory(Category category)throws ServiceException;
	//批量删除分类
	void deleteCategoryInBatch(List<Long> ids)throws ServiceException;
	
	//按序号升序查询分类信息，并进行分页
	Page<Category> findAllSortbyno(Integer pageNum,Integer pageSize)throws ServiceException;
	
	//更新分类序号
	void updateCategoryNo(Long id,Long no)throws ServiceException;
	
}
