package com.briup.cms.service.impl;
/*
 * 方法描述
 *Column接口
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Column;
import com.briup.cms.bean.Information;
import com.briup.cms.dao.ColumnDao;
import com.briup.cms.dao.InformationDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.ColumnService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Api(tags = "栏目管理模块")
@RequestMapping("column")
public class ColumnServiceImpl implements ColumnService {


   @Autowired
   private InformationDao informationDao;

   @Autowired
   private ColumnDao columnDao;

    @Override
    @GetMapping("/findAll")
    public List<Column> findAll() throws ServiceException {
        return columnDao.findAll();
    }

    @Override
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public Page<Column> findAll(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, HttpServletResponse response) throws ServiceException {
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return columnDao.findAll(pageable);
    }

    @PostMapping("/save")
    @Override
    public String save(@RequestBody Column column) throws ServiceException {
        Column result = null;
        if (column.getColumname()!=null && column.getColumname()!=""){
            result = columnDao.save(column);
        }
        if (result!=null ){
            return "success";
        }
        else {
            System.out.println("error");
            return "error";
        }

    }

    @Override
    @GetMapping("/findById/{id}")
    public Column findById(@PathVariable("id") Integer id) throws ServiceException {
        return columnDao.findById(id).get();
    }

    @Override
    @PutMapping("/update")
    public String update(@RequestBody Column column) throws ServiceException {
        Column result = null;
        if (column.getColumname()!=null && column.getColumname()!=""){
            result = columnDao.save(column);
        }
        if (result!=null ){
            return "success";
        }
        else {
            System.out.println("error");
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    @Override
    public void delete(@PathVariable("id") Integer id) throws ServiceException {
        System.out.println("id1:"+id);
        List<Information> all = informationDao.findAll();
        for (Information information: all) {
            Integer delId = information.getColumnId().getId();
            if (delId==id){
                informationDao.deleteById(information.getId());
            }
            System.out.println("关联的信息删除成功一个");
        }
        System.out.println("关联的信息删除全部成功");
        System.out.println("id2:"+id);
        System.out.println("栏目开始删除");
        columnDao.deleteById(id);
        System.out.println("栏目结束删除");

    }
}
