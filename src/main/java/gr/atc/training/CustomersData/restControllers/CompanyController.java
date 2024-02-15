package gr.atc.training.CustomersData.restControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import gr.atc.training.CustomersData.models.Company;
import gr.atc.training.CustomersData.models.Customer;
import gr.atc.training.CustomersData.services.CustomerService;

import java.util.List;

@Configuration
@Controller

@RequestMapping("/api/v1/company")
public class CompanyController<InMemoryUserDetailsManager> {

	@Autowired
	private Company companyService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id) {
		return ResponseEntity.ok(companyService.findCompanyId(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
		return ResponseEntity.ok(true);
	}

	@PostMapping("/")
	public ResponseEntity<Object> createCompany(@RequestBody Company company) {
		System.out.println(company);
		return ResponseEntity.ok(companyService.createNewCompany(company));
	}

	@GetMapping("/{firstName}/{lastName}")
	public ResponseEntity<Object> getCustomerByLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return ResponseEntity.ok(companyService.getCustomerByFirstNameOrLastName(firstName, lastName));
	}
}
