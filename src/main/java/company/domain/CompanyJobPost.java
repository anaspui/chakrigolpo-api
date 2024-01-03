package company.domain;

import company.domain.Company;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity(name= "company_job_post")
public class CompanyJobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotNull(message = "Only Companies can post jobs!")
    private Company company;

    @Column(name = "job_title")
    @NotNull(message = "Title cannot be null")
    private String jobTitle;

    @Column(name = "job_description")
    @NotNull(message = "Job must have a description")
    private String jobDescription;
    @Column(name = "created_at")
    @Past(message = "Please select a valid date")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // other fields, getters, and setters
    public CompanyJobPost() {

    }
    public CompanyJobPost(Company company, String jobTitle, String jobDescription, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.company = company;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CompanyJobPost{" +
                "jobId=" + jobId +
                ", company=" + company +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
