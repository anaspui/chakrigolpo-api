package company.service;

import company.domain.CompanyJobPost;
import company.repository.CompanyJobPostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyJobPostService {

    private final CompanyJobPostRepository companyJobPostRepository;

    public CompanyJobPostService(CompanyJobPostRepository companyJobPostRepository) {
        this.companyJobPostRepository = companyJobPostRepository;
    }

    public Object create(CompanyJobPost companyJobPost) {
        return companyJobPostRepository.create(companyJobPost);
    }


    public CompanyJobPost findById(int id) {
        return companyJobPostRepository.findById(id);
    }

    public List<CompanyJobPost> getAll() {
        return companyJobPostRepository.getAll();
    }
    public void delete(int id){
        this.companyJobPostRepository.delete(id);
    }
    public void update(CompanyJobPost post){
        this.companyJobPostRepository.update(post);
    }
}
