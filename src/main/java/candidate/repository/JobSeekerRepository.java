package candidate.repository;

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


    public JobSeeker getOne(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(JobSeeker.class, id);
    }
}
