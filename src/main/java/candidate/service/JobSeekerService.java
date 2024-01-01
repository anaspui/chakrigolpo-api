package candidate.service;

import candidate.domain.JobSeeker;
import candidate.repository.JobSeekerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class JobSeekerService {

    private JobSeekerRepository jobSeekerRepository;


    public JobSeekerService(JobSeekerRepository jobSeekerRepository){
        this.jobSeekerRepository = jobSeekerRepository;
    }


    public JobSeeker findbyId(int id){
        return jobSeekerRepository.getOne(id);
    }
}
