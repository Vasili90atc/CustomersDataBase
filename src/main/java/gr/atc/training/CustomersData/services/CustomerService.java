package gr.atc.training.CustomersData.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.atc.training.CustomersData.models.Customer;
import gr.atc.training.CustomersData.repositories.CustomerRepository;


@Service
public class CustomerService { 
	
	@Autowired
	private CustomerRepository customersRepository; 
	
	public Customer createNewCustomer(Customer customer) { 
		return customersRepository.save(customer); 
	}
	
	public List<Customer> getHead10Customers(){
		List<Customer> l = customersRepository.findAll();
		return l.subList(0, 10);
	}
	
	public List<Customer> getAllCustomers() { 
		return customersRepository.findAll(); 
	} 
	
	public void deleteCustomer(String email) {
		Customer customer = customersRepository.findByEmail(email);
		customersRepository.delete(customer);
	}
	
	public Customer updateCustomer(Customer email) { 
		return customersRepository.save(email); 
	}

	public Customer findCustomerByEmail(String email) {
		return customersRepository.findByEmail(email);
	}
	
	public List<Customer> getCustomerByLastName(String lastName) {
		return customersRepository.findByLastName(lastName);
	}
	
	public List<Customer> getCustomerByFirstNameOrLastName(String firstName, String lastName) {
		System.out.println(firstName + " " + lastName);
		return customersRepository.findByFirstNameOrLastName(firstName,lastName);
	}
	
}