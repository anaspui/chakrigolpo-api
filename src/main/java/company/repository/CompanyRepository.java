package company.repository;



import company.domain.Company;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository {
    private SessionFactory sessionFactory;

    public CompanyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object create(Company company) {
        Session session = sessionFactory.getCurrentSession();
        Object sa = session.save(company);
        return sa;

    }




    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = findById(id);
        session.delete(company);
    }

    public List<Company> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Company> companyQuery = session.createQuery("FROM Company", Company.class);

        return companyQuery.getResultList();
    }

    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }
}
