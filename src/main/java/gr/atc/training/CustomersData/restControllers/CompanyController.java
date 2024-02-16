package gr.atc.training.CustomersData.restControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import gr.atc.training.CustomersData.models.Company;
import gr.atc.training.CustomersData.services.CompanyService;

@Configuration
@Controller
@RequestMapping("/api/v1/company")
public class CompanyController<InMemoryUserDetailsManager> {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/")
	public ResponseEntity<Object> createCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.createNewCompany(company));
	}
	@GetMapping("/")
	public ResponseEntity<Object> getAllCompanies() {
		return ResponseEntity.ok(companyService.getAllCompanies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCompany(@PathVariable int id) {
		return ResponseEntity.ok(companyService.getCompanyById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
		return ResponseEntity.ok(true);
	}
	
	
}
