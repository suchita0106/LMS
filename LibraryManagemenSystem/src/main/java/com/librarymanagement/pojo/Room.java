package com.librarymanagement.pojo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "roomname")
    private String roomName;
    
    @Temporal(TemporalType.TIMESTAMP)  // Used for date and time
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "starttime")
    private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)  // Used for date and time
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "endtime")
    private Date endTime;
	
    @Column(name = "capacity")
    private int capacity;
	
    @Column(name = "roomstatus")
	private String status;
        
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
