package com.briup.cms.dao;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import com.briup.cms.bean.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationDao extends JpaRepository<Information,Integer> {
}
