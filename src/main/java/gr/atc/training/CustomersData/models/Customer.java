package gr.atc.training.CustomersData.models;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	// this is the primary key
	private String email;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "company_name")
	private String companyName;
	private String address;
	private String city;
	private String county;
	private String state;
	private int zip;
	private String phone1;
	private String phone2;
	private String web;
	
	@ManyToMany
	@JoinTable(name = "customer_company")
    Set<Company> companies = new HashSet<>();
	
	public Customer() {}

	public void addCompany(Company company) {
		companies.add(company);
		company.addCustomer(this);
	}
	public void removeCompany(Company company) {
		companies.remove(company);
		company.removeCustomer(this);
	}
	
	public String getFirst_name() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getCompanyname() {
		return companyName;
	}

	public void setCompanyname(String companyname) {
		this.companyName = companyname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", " + "firstName=" + firstName + " , " + " lastName=" + " , " + lastName+ "," + 
	" companyName=" + companyName + " , " + "address=" + address + " , " + " city=" + city + " , " + " county=" + county + " , "+ 
	" state=" + state + " , " + "zip=" + zip + "," +  " phone1=" + phone1 + " , " + " phone2=" + phone2 + " , " + "web=" +  web + "]";
	}
	
}