package net.codejava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
public class Teacher {
	
	private Integer id;
	@NotBlank
	@Column(unique = true)
	private String nickName;
	@Size(min = 3, max = 45)
	private String firstName;
	@Size(min = 3, max = 45)
	private String lastName;
	@NotBlank
    @Size(min = 8, max = 15)
    private String password;
	private float price;
	@Size(max = 100)
	private String languages;
	@NotBlank
	@Column(unique = true)
    @Email(message = "Please enter a valid e-mail address")
    private String email;

	public Teacher() {
	}

	public Teacher(Integer id,String nickName, String firstName, String lastName, String password, float price, String Languages, String email) {
		this.id = id;
		this.nickName = nickName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.price = price;
		this.languages = Languages;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
