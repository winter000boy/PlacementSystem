package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String collegeName;
    private String location;

    @OneToOne
    private User collegeAdmin;
    

	public College() {

	}


	public College(Long id, String collegeName, String location, User collegeAdmin) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.location = location;
		this.collegeAdmin = collegeAdmin;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public User getCollegeAdmin() {
		return collegeAdmin;
	}


	public void setCollegeAdmin(User collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}


	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + ", collegeAdmin="
				+ collegeAdmin + "]";
	}

    
}
