package candidate.domain;

import company.domain.CompanyJobPost;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private CompanyJobPost job;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime appliedAt;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public CompanyJobPost getJob() {
        return job;
    }

    public void setJob(CompanyJobPost job) {
        this.job = job;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
// other fields, getters, and setters

    public enum Status {
        APPROVED, PENDING, REJECTED
    }
}
