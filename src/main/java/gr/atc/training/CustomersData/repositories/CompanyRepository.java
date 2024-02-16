package gr.atc.training.CustomersData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.atc.training.CustomersData.models.Company;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public Company findById(int Id);
	public List<Company> findByAddress(String address);
	public List<Company> findByName(String name);
}