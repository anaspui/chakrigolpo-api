package company.domain;

import auth.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name="company_name")
    private String companyName;
    @Column(name = "industry")
    private String industry;
    @Column(name="closing_time")
    private Date closingTime;

//    @OneToMany(mappedBy = "company")
//    private Set<CompanyJobPost> jobPosts;

    // other fields, getters, and setters

    public Company() {
    }

//    public Company(User user, String companyName, String industry, Date closingTime, Set<CompanyJobPost> jobPosts) {
//        this.user = user;
//        this.companyName = companyName;
//        this.industry = industry;
//        this.closingTime = closingTime;
//        this.jobPosts = jobPosts;
//    }
public Company(User user, String companyName, String industry, Date closingTime) {
    this.user = user;
    this.companyName = companyName;
    this.industry = industry;
    this.closingTime = closingTime;
}

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
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

//    public Set<CompanyJobPost> getJobPosts() {
//        return jobPosts;
//    }
//
//    public void setJobPosts(Set<CompanyJobPost> jobPosts) {
//        this.jobPosts = jobPosts;
//    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", user=" + user +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", closingTime=" + closingTime +
                '}';
    }
}
