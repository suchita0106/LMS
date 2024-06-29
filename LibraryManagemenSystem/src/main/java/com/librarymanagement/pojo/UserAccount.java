package com.librarymanagement.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

	public UserAccount() {
		// TODO Auto-generated constructor stub
	}
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "username")
	    private String username;
	    
	    @Column(name = "pasword")
	    private String password;

	    @Column(name="userrole")
	    private String role;
	    
	    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn
	    private UserProfile userProfile;
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	    
	    public UserProfile getUserProfile() {
	        return userProfile;
	    }

	    public void setUserProfile(UserProfile userProfile) {
	        this.userProfile = userProfile;
	    }
	    
}
