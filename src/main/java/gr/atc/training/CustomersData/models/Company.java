package gr.atc.training.CustomersData.models;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Company {

	@Id
	//this is the primary key
	private int id;
	@Column(name = "Name")
	private String name;
	private String address;
	
	@ManyToMany(mappedBy = "companies")
    Set<Customer> customers = new HashSet<Customer>();
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void removeCustomer(Customer customer) {
		customers.remove(customer);		
	}
	
	public Company() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String companyName) {
		this.name = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Company [ Id=" + id + ", " + "companyName=" + name + " , " + "address=" + address + "]";
	}


}
