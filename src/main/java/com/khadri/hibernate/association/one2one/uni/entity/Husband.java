package com.khadri.hibernate.association.one2one.uni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Husband")
@Table(name = "HUSBAND")
public class Husband {

	@Id
	@Column(name = "H_ADHAAR_NO")
	private String id;

	@Column(name = "NAME")
	private String name;

	@OneToOne
	@JoinColumn(name = "WIFE_ID", foreignKey = @ForeignKey(name = "HUSBAND_WIFE_FK"))
	private Wife wife;

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

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

}
