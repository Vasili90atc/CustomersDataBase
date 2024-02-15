package gr.atc.training.CustomersData.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.atc.training.CustomersData.models.Company;
import gr.atc.training.CustomersData.models.Customer;
import gr.atc.training.CustomersData.repositories.CompanyRepository;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companysRepository;

	public Company createNewCompany(Company company) {
		return companysRepository.save(company);
	}

	/*public List<Customer> getHead10Customers() {
		List<Company> l = companyRepository.findAll();
		return l.subList(0, 10);
	} */

	public List<Company> getAllCustomers() {
		return companysRepository.findAll();
	}

	public void deleteCompany(int id) {
		@SuppressWarnings("deprecation")
		Company company = companysRepository.getById(id);
		companysRepository.delete(company);
	}

	public Company updateCompany(Company id) {
		return companysRepository.save(id);
	}

	public Company getCustomerById(String id) {
		return companysRepository.findById(id);
	}
	
	public String getCompanyByName(String companyName, int id) {
		System.out.println(companyName);
		return CompanyRepository.findBycompanyName(companyName);
	}
}