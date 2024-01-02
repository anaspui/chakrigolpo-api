package company.domain;

import auth.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "A user must be assigned to the Company")
    private User user;


    @Column(name="company_name")
    @NotNull(message = "Company Name cannot be Null")
    private String companyName;
    @Column(name = "industry")
    @NotNull(message = "Industry cannot be null")
    private String industry;
    @Column(name="closing_time")
    private Date closingTime;


    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<CompanyJobPost> jobPosts;





    public Company() {
    }

    public Company(User user, String companyName, String industry, Date closingTime, Set<CompanyJobPost> jobPosts) {
        this.user = user;
        this.companyName = companyName;
        this.industry = industry;
        this.closingTime = closingTime;
        this.jobPosts = jobPosts;
    }
//public Company(User user, String companyName, String industry, Date closingTime) {
//    this.user = user;
//    this.companyName = companyName;
//    this.industry = industry;
//    this.closingTime = closingTime;
//}

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

    public Set<CompanyJobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<CompanyJobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", user=" + user +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", closingTime=" + closingTime +
                ", jobPosts=" + jobPosts +
                '}';
    }
}
