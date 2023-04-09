package com.khadri.hibernate.association.one2one.uni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Wife")
@Table(name = "WIFE")
public class Wife {

	@Id
	@Column(name = "W_ADHAAR")
	private String id;

	@Column(name = "W_NAME")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
