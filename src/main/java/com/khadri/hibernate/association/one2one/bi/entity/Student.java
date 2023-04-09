package com.khadri.hibernate.association.one2one.bi.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Student")
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Column(name = "STD_ID")
	private UUID id;

	@Column(name = "STD_NAME")
	private String name;

	@OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "ADDRESS_ID", foreignKey = @ForeignKey(name = "STUDENT_ADDRESS_FK"))
	private Address address;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
