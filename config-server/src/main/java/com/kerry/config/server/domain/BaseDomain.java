package com.kerry.config.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author kerry dong
 */
@Entity
public class BaseDomain {

	@Id
	@GeneratedValue
	private Long id;


	private String creator;


	private String modifier;


	private Date gmtModifier;


	private Date gmtCreator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getGmtModifier() {
		return gmtModifier;
	}

	public void setGmtModifier(Date gmtModifier) {
		this.gmtModifier = gmtModifier;
	}

	public Date getGmtCreator() {
		return gmtCreator;
	}

	public void setGmtCreator(Date gmtCreator) {
		this.gmtCreator = gmtCreator;
	}
}
