package com.briup.cms.bean;

import com.briup.cms.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/*
 * 方法描述
 *  信息
 * $ 参数描述
 * @author create by 作者 on $ $
 * @return $
 */
@Entity
@Table(name="cms_information")
@Data
//@JsonSerialize(using = DateJsonSerializer.class)
public class Information {

    private static final long serialVersionUID = 1L;
    /**
     * 编号（主键）
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date time;

    /**
     * 点击次数
     */
    private int num;

    /**
     * 外键 栏目_id
     */
    @ManyToOne
    @JoinColumn(name="column_id")
    private Column columnId;




    /**
     * 内容
     */
    private String content;

    /**
     * 栏目名字
     */
    private String columname;
}
