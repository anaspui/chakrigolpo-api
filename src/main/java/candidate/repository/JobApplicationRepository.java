package candidate.repository;

import candidate.domain.JobApplication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobApplicationRepository {
    private SessionFactory sessionFactory;

    public JobApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Object create(JobApplication application) {
        Session session = sessionFactory.getCurrentSession();
        Object newApplication = session.save(application);
        return newApplication;
    }
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        JobApplication application = findById(id);
        session.delete(application);
    }
    public List<JobApplication> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<JobApplication> applicationQuery = session.createQuery("From job_application ", JobApplication.class);

        return applicationQuery.getResultList();
    }

    public JobApplication findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(JobApplication.class, id);
    }
    public void update(JobApplication  application){
        Session session= sessionFactory.getCurrentSession();
        session.update(application);
    }
}
