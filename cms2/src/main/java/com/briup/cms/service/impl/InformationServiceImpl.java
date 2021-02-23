package com.briup.cms.service.impl;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Column;
import com.briup.cms.bean.Information;
import com.briup.cms.dao.ColumnDao;
import com.briup.cms.dao.InformationDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.InformationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@Api(tags = "文章信息管理模块")
@RequestMapping("information")
public class InformationServiceImpl implements InformationService {
   @Autowired
   private InformationDao informationDao;

   @Autowired
   private ColumnDao columnDao;

    @Override
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public Page<Information> findAll(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize) throws ServiceException {
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return informationDao.findAll(pageable);
    }

    @DeleteMapping("/deleteById/{id}")
    @Override
    public void delete(@PathVariable("id") Integer id) throws ServiceException {
        informationDao.deleteById(id);
    }

    @Override
    public String save(Information information, Integer id) throws ServiceException {
        return null;
    }


    @Override
    @PostMapping("/save2")
    public String save2(@RequestBody Information information ) throws ServiceException {
        String res;
        Information result = null;
        //此时的columname便是column的id，需要转为int
        String columname = information.getColumname();
        int columnid = Integer.parseInt(columname);
        Column column = columnDao.findById(columnid).get();
        //此时的columnname才是真正的column值
        columname = column.getColumname();
        information.setColumname(columname);
        //将通过cid查询到的column对象放入columnId中
        information.setColumnId(column);

        //将提交时间保存
        Date date = new Date();
        information.setTime(date);
//        information.setId(cid);
        System.out.println(information.toString());
        if (information.getAuthor() != null && information.getAuthor() != "") {
            result = informationDao.save(information);
        }
        if (result != null) {
            res = "success";
        } else {
            System.out.println("error");
            res = "error";
        }

        return res;
    }

    @Override
    @GetMapping("/findById/{id}")
    public Information findById(@PathVariable("id") Integer id) throws ServiceException {
        return informationDao.findById(id).get();
    }

}
