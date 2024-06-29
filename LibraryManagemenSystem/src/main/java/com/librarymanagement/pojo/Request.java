package com.librarymanagement.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "BOOK_REQUESTS")
public class Request {

	public Request() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@Column(name="book_id")
	private Long bookID;	
	
	@Column(name="book_name")
	private String bookName;

	@Column(name="user_id")
	private Long userId;
	
	@Column(name="username")
	private String userName;

	@Column(name="adminusername")
	private String adminusername;
	
	//@Column(name="request_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)  // Used for date and time
    @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy")
	@Column(name="request_date")
	private Date IssueDate;


	//@Column(name="return_date", columnDefinition = "DATE DEFAULT CURRENT_DATE + INTERVAL 10 DAY")
    @Temporal(TemporalType.TIMESTAMP)  // Used for date and time
    @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy")
	@Column(name="return_date")
	private Date ReturnDate;
	
	@Column(name="status_flg")	
	private char statusFlg;
	
	@Column(name="admin_id")
	private Long adminUserAccount;
	

	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}

	public Date getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}

	public char getStatusFlg() {
		return statusFlg;
	}

	public void setStatusFlg(char statusFlg) {
		this.statusFlg = statusFlg;
	}

	public Long getAdminUserAccount() {
		return adminUserAccount;
	}

	public void setAdminUserAccount(Long adminUserAccount) {
		this.adminUserAccount = adminUserAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	


	
	

}
