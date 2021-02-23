package com.briup.cms.bean;
/*
 * 方法描述
 *
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="cms_link")
public class Link {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    //id
    private int id;
    @javax.persistence.Column(nullable = false)
    private String linkname;
    @javax.persistence.Column(nullable = false)
    private String linkaddress;
}
