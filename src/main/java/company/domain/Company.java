package company.domain;

import auth.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String companyName;
    private String industry;
    private Date closingTime;

    @OneToMany(mappedBy = "company")
    private Set<CompanyJobPost> jobPosts;

    // other fields, getters, and setters

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public Set<CompanyJobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<CompanyJobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }
}
