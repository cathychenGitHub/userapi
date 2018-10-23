package cathyhome.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
    private int userId; 
	
	@Column(name="name")
    private String name;
	
	@Column(name="email")	
	private String email;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int uid) {
		this.userId = uid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String nm) {
		this.name = nm;
	}
	
	public String getEmail() {		
		return email;
	}
	public void setEmail(String e) {
		this.email = e;
	}
} 