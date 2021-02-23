package com.briup.cms.service.impl;
/*
 * 方法描述
 *link 接口
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Link;
import com.briup.cms.dao.LinkDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.LinkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("link")
@Api(tags = "链接管理模块")
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    @Override
    @GetMapping("/findAll/{pageNum}/{pageSize}")
    public Page<Link> findAll(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, HttpServletResponse response) throws ServiceException {
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return linkDao.findAll(pageable);
    }

    @PostMapping("/save")
    @Override
    public String save(@RequestBody Link link) throws ServiceException {
        Link result = null;
        if (link.getLinkname()!=null && link.getLinkaddress() != null && link.getLinkname()!=""&& link.getLinkaddress()!="" ){
            result = linkDao.save(link);
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
    public Link findById(@PathVariable("id") Integer id) throws ServiceException {
        return linkDao.findById(id).get();
    }

    @Override
    @PutMapping("/update")
    public String update(@RequestBody Link link) throws ServiceException {
        Link result = null;
        if (link.getLinkname()!=null && link.getLinkaddress() != null && link.getLinkname()!=""&& link.getLinkaddress()!="" ){
            result = linkDao.save(link);
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
        linkDao.deleteById(id);
    }
}
