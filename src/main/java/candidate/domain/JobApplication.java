package candidate.domain;

import company.domain.CompanyJobPost;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "job_application")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int applicationId;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private CompanyJobPost job;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;
    public JobApplication() {}

    public JobApplication(JobSeeker jobSeeker, CompanyJobPost job, Status status, LocalDateTime appliedAt) {
        this.jobSeeker = jobSeeker;
        this.job = job;
        this.status = status;
        this.appliedAt = appliedAt;
    }
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
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


    public enum Status {
        APPROVED, PENDING, REJECTED
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationId=" + applicationId +
                ", jobSeeker=" + jobSeeker +
                ", job=" + job +
                ", status=" + status +
                ", appliedAt=" + appliedAt +
                '}';
    }
}
