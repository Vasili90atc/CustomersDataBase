package gr.atc.training.CustomersData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.atc.training.CustomersData.models.Company;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public Company findById(String Id); 
	//public List<Company> findByFirstName(String firstName);
	//public List<Company> findByFirstNameOrLastName(String firstName, String lastName);
	public List<Company>findByAddress(String address);
	public List<Company> findByCompany(int Id, String companyName, String address);
	
	public static String findBycompanyName(String companyName) {
		return companyName;
	}
	
}