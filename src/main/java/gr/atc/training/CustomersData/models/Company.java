package gr.atc.training.CustomersData.models;
import java.util.Set;

import gr.atc.training.CustomersData.models.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Company {

	@Id
//this is the primary key
	private int id;
	@Column(name = "company_name")
	private String companyName;
	private String address;
	
	@ManyToMany(mappedBy = "companies")
    Set<Customer> customers;
	public Company() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Company [ Id=" + id + ", " + "companyName=" + companyName + " , " + "address=" + address + "]";
	}

	public Object getHead10Company() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object createNewCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCustomerByFirstNameOrLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		
	}

	public Object findCompanyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		
	}
}
