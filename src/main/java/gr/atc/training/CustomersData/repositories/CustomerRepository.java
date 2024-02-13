package gr.atc.training.CustomersData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import gr.atc.training.CustomersData.models.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	public Customer findByEmail(String email); 
	public List<Customer> findAll();
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByFirstName(String firstName);
	public List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
}
