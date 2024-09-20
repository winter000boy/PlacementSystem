package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    private College college;
    private Long rollNo;
    private String qualification;
    private String course;
    private int year;

    @ManyToOne
    private Certificate certificate;
    private Long hallTicketNo;
    
	public Student() {
		
	}

	public Student(Long id, String name, College college, Long rollNo, String qualification, String course, int year,
			Certificate certificate, Long hallTicketNo) {
		
		this.id = id;
		this.name = name;
		this.college = college;
		this.rollNo = rollNo;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.certificate = certificate;
		this.hallTicketNo = hallTicketNo;
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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Long getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(Long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", rollNo=" + rollNo
				+ ", qualification=" + qualification + ", course=" + course + ", year=" + year + ", certificate="
				+ certificate + ", hallTicketNo=" + hallTicketNo + "]";
	}
	

   
}
