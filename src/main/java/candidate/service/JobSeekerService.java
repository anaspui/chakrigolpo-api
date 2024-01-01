package candidate.service;

import auth.domain.User;
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
    public void create(JobSeeker jobSeeker) {
        jobSeekerRepository.create(jobSeeker);
    }

    public void update(JobSeeker jobSeeker) {
        jobSeekerRepository.update(jobSeeker);
    }
    public JobSeeker getOne(int id){
        return jobSeekerRepository.getOne(id);
    }
    public void deleteUser(int id) {
        jobSeekerRepository.deleteById(id);
    }
}
