package com.cdac.oralcaremanagement.entity;

import java.time.LocalDate;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uId")
	private Integer userId;

	@Column(name = "firstname")
	private String fName;

	@Column(name = "lastname")
	private String lName;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private  String mobileNo;

	private String gender;

	private LocalDate dob;

	@Column(name = "p_que", length = 100)
	private String que;

	@Column(name = "p_ans", length = 50)
	private String ans;

	@Column(name = "UserRole")
	private String userrole;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String fName, String lName, String email, String password, String mobileNo,
			String gender, LocalDate dob, String que, String ans, String userrole) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.que = que;
		this.ans = ans;
		this.userrole = userrole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + ", que=" + que
				+ ", ans=" + ans + ", userrole=" + userrole + "]";
	}
	

	
}
