/**
 * @author akp
 *
 */
package hello;

import org.springframework.data.annotation.Id;

/** Bonus Task 2:
 * Add a database to store your data.  
 * Either store form or REST data in a database and add a method in your controller to get this data out.
 * The Model Class - Candidates
 */
public class Candidate {


	@Id
	private Long 	id;
	private String 	firstName;
	private String	lastName;
	private Integer	experience;
	private String  contactNo;

	public Candidate(){
		
	}

	public Candidate(Long id, String firstName, String lastName, Integer experience, String contactNo){	
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
		this.contactNo = contactNo;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
