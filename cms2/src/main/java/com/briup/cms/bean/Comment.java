package com.briup.cms.bean;

import com.briup.cms.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 评论
 */
@Entity
@Table(name="cms_comment")
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号（主键）
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 评论内容
	 */
	private String content;
	
	/**
	 * 评论时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;
	
	/**
	 * 评论人
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * 评论的文章
	 */
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;
	
	/**
	 * 评论的回复，也就是评论的评论
	 */
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Comment comment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonSerialize(using = DateJsonSerializer.class)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
