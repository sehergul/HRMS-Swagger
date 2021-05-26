package com.example.hrmsSpringBoot.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 						//karsilik geldigi katman
@Table(name = "users")			//karsilik geldigi tablo adi
public class User {
	
	@Id						//tablodaki id kolonunun verilmesi lazim- primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//birer birer artirarak
	@Column(name = "id")	//karsilik geldigi kolon
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	public User() {}


	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
}