package company.repository;

import company.domain.CompanyJobPost;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyJobPostRepository {
    private SessionFactory sessionFactory;

    public CompanyJobPostRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object create(CompanyJobPost company) {
        Session session = sessionFactory.getCurrentSession();
        Object sa = session.save(company);
        return sa;
    }
    
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        CompanyJobPost company = findById(id);
        session.delete(company);
    }

    public List<CompanyJobPost> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<CompanyJobPost> companyQuery = session.createQuery("From company_job_post", CompanyJobPost.class);

        return companyQuery.getResultList();
    }

    public CompanyJobPost findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CompanyJobPost.class, id);
    }
    public void update(CompanyJobPost post){
        Session session= sessionFactory.getCurrentSession();
        session.update(post);
    }
}
