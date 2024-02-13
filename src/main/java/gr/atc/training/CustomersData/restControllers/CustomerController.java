package gr.atc.training.CustomersData.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import gr.atc.training.CustomersData.models.Customer;
import gr.atc.training.CustomersData.services.CustomerService;

import java.util.List;

@Configuration
@Controller

@RequestMapping("/api/v1/customers")
public class CustomerController<InMemoryUserDetailsManager> {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getHead10Customers());
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String email) {
		return ResponseEntity.ok(customerService.findCustomerByEmail(email));
	}

	@DeleteMapping("/{email}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable String email) {
		customerService.deleteCustomer(email);
		return ResponseEntity.ok(true);
	}

	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return ResponseEntity.ok(customerService.createNewCustomer(customer));
	}

	@GetMapping("/{firstName}/{lastName}")
	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		return ResponseEntity.ok(customerService.getCustomerByFirstNameOrLastName(firstName, lastName));
	}
}
