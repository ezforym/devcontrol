/*
 * User.java
 * Copyright(C) 2013-2015 成都PLZT科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.wyz.pojo;

import java.io.Serializable;

/**
 * 用户表
 * 
 * @author Jacky
 * @version 1.0
 * @date 2015年11月06日
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private Integer id;
	private String name;
	private String phone;
	private boolean dr;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDr() {
		return dr;
	}

	public void setDr(boolean dr) {
		this.dr = dr;
	}
}