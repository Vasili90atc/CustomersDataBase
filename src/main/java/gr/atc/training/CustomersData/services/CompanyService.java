package gr.atc.training.CustomersData.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.atc.training.CustomersData.models.Company;
import gr.atc.training.CustomersData.repositories.CompanyRepository;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company createNewCompany(Company company) {
		return companyRepository.save(company);
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	public void deleteCompany(int id) {
		Company company = companyRepository.getReferenceById(id);
		companyRepository.delete(company);
	}

	public Company updateCompany(Company company) {
		return companyRepository.save(company);
	}

	public Company getCompanyById(int id) {
		return companyRepository.findById(id);
	}
	
	public List<Company> getCompanyByName(String name) {
		return companyRepository.findByName(name);
	}
}