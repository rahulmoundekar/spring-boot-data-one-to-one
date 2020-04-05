package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table
public class License {

	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	private Integer id;

	@Column(name = "license_number")
	private String licenseNumber;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "person_id")
	@JsonBackReference
	private Person person;
}
