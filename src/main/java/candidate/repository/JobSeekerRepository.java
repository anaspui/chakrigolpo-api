package candidate.repository;

import auth.domain.Role;
import auth.domain.User;
import candidate.domain.JobSeeker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class JobSeekerRepository {
    private SessionFactory sessionFactory;
    public JobSeekerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(JobSeeker jobSeeker) {
        Session session = sessionFactory.getCurrentSession();
        session.save(jobSeeker);
    }
    public void update(JobSeeker jobSeeker) {
        Session session = sessionFactory.getCurrentSession();
        JobSeeker existing = (JobSeeker) session.merge(jobSeeker);
        existing.setBiography(jobSeeker.getBiography());
        existing.setFullName(jobSeeker.getFullName());
        existing.setUser(jobSeeker.getUser());
        existing.setResumePath(jobSeeker.getResumePath());
        existing.setProfilePicturePath(jobSeeker.getProfilePicturePath());
        existing.setCoverLetterPath(jobSeeker.getCoverLetterPath());
        session.flush();
    }
    public JobSeeker getOne(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(JobSeeker.class, id);
    }
}
