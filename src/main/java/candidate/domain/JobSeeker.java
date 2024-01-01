package candidate.domain;

import auth.domain.User;

import javax.persistence.*;

@Entity(name = "job_seeker")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "job_seeker_id")
    private int jobSeekerId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name= "full_name")
    private String fullName;
    @Column(name= "biography")
    private String biography;
    @Column(name= "cover_letter_path")
    private String coverLetterPath;
    @Column(name= "resume_path")
    private String resumePath;
    @Column(name= "profile_picture_path")
    private String profilePicturePath;

    // other fields, getters, and setters

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getCoverLetterPath() {
        return coverLetterPath;
    }

    public void setCoverLetterPath(String coverLetterPath) {
        this.coverLetterPath = coverLetterPath;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "jobSeekerId=" + jobSeekerId +
                ", user=" + user +
                ", fullName='" + fullName + '\'' +
                ", biography='" + biography + '\'' +
                ", coverLetterPath='" + coverLetterPath + '\'' +
                ", resumePath='" + resumePath + '\'' +
                ", profilePicturePath='" + profilePicturePath + '\'' +
                '}';
    }
}
