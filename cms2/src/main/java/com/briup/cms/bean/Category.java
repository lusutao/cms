package com.briup.cms.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章分类
 */
@Entity
@Table(name="cms_category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号（主键）
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 *  分类名
	 */
	private String name;
	
	/**
	 *  分类描述信息
	 */
	private String description;
	
	/**
	 * 分类序号（将来可以通过序号值改变分类的排序）
	 */
	private int no;
	
	/**
	 * 当前分类所属一级分类对象（如果没有则为null）
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private Category category;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	private List<Article> articleList=new ArrayList<>();
	
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
