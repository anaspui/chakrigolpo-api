package company.domain;

import candidate.domain.JobSeeker;
import company.domain.Company;
import company.domain.CompanyJobPost;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="applicant_download")
public class ApplicantDownload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int downloadId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private CompanyJobPost job;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @Column(name = "download_at")
    private LocalDateTime downloadAt;

    // other fields, getters, and setters


    public ApplicantDownload() {
    }

    public ApplicantDownload(Company company, CompanyJobPost job, JobSeeker jobSeeker, LocalDateTime downloadAt) {
        this.company = company;
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.downloadAt = downloadAt;
    }

    public int getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(int downloadId) {
        this.downloadId = downloadId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyJobPost getJob() {
        return job;
    }

    public void setJob(CompanyJobPost job) {
        this.job = job;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public LocalDateTime getDownloadAt() {
        return downloadAt;
    }

    public void setDownloadAt(LocalDateTime downloadAt) {
        this.downloadAt = downloadAt;
    }

    @Override
    public String toString() {
        return "ApplicantDownload{" +
                "downloadId=" + downloadId +
                ", company=" + company +
                ", job=" + job +
                ", jobSeeker=" + jobSeeker +
                ", downloadAt=" + downloadAt +
                '}';
    }
}
