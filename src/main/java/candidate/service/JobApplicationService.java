package candidate.service;

import candidate.domain.JobApplication;
import candidate.repository.JobApplicationRepository;
import company.domain.CompanyJobPost;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public Object create(JobApplication jobApplication) {
        return jobApplicationRepository.create(jobApplication);
    }

    public JobApplication findById(int id) {
        return jobApplicationRepository.findById(id);
    }

    public List<JobApplication> getAll() {
        return jobApplicationRepository.getAll();
    }

    public void delete(int id){
        this.jobApplicationRepository.delete(id);
    }
    public void update(JobApplication post){
        this.jobApplicationRepository.update(post);
    }
}
