package company.service;

import auth.domain.User;
import company.domain.Company;
import company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Object create(Company company) {
        return companyRepository.create(company);
    }


    public Company findById(int companyId) {
        return companyRepository.findById(companyId);
    }

    public List<Company> getAll() {
        return companyRepository.getAll();
    }
    public void delete(int id){
        this.companyRepository.delete(id);
    }
}
