package candidate.controller;

import auth.domain.Role;
import auth.domain.User;
import auth.service.UserService;
import candidate.domain.JobSeeker;
import candidate.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@RestController
@RequestMapping("/candidate")
public class JobSeekerRestController {

    @Autowired
    private final JobSeekerService jobSeekerService;
    @Autowired
    private final UserService userService;


    public JobSeekerRestController(JobSeekerService jobSeekerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.userService = userService;
    }

//    @PostMapping("/jobseeker")
//    public String createUser(@RequestBody JobSeeker jobSeeker) {
//        jobSeekerService.create(jobSeeker);
//        return "Successful";
//    }


    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getUserById(@PathVariable int id) {
        JobSeeker user = jobSeekerService.findbyId(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public String updateUser(@RequestBody JobSeeker jobSeeker){

        jobSeekerService.update(jobSeeker);

        return "Successful";
    }
    @DeleteMapping("/jobseeker/{id}")
    public String deleteUser(@PathVariable int id){

        jobSeekerService.deleteUser(id);

        return "Successful";
    }

    @PostMapping
    public String createUser(@RequestBody JobSeeker jobSeeker){
        jobSeeker.setProfilePicturePath("null");
        jobSeeker.setResumePath("null");
        jobSeeker.setCoverLetterPath("null");

        jobSeekerService.create(jobSeeker);

        return "Successful";
    }




    @PostMapping("/upload/resume")
    public String uploadResume(@RequestParam("file") MultipartFile resumeFile,
                               @RequestParam("jobSeekerId") int jobSeekerId) {
        try {
            JobSeeker jobSeeker = jobSeekerService.getOne(jobSeekerId);
            if (jobSeeker != null) {
                String resumePath = saveFile(resumeFile, "resume");
                jobSeeker.setResumePath(resumePath);
                jobSeekerService.update(jobSeeker);
                return "Resume uploaded successfully";
            } else {
                return "JobSeeker not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred during file upload.";
        }
    }
    @GetMapping("/resume/{fileName}")
    public ResponseEntity<Resource> downloadResume(@PathVariable String fileName) throws IOException {
        return getResume(fileName);
    }
    private ResponseEntity<Resource> getResume(String fileName) throws IOException {
        String uploadDirectory = "/uploads/resume/";
        String filePath = uploadDirectory + fileName;
        Resource resource = new UrlResource(Paths.get(filePath).toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload/cover")
    public String uploadCoverLetter(@RequestParam("file") MultipartFile coverLetterFile,
                                    @RequestParam("jobSeekerId") int jobSeekerId) {
        try {
            JobSeeker jobSeeker = jobSeekerService.getOne(jobSeekerId);
            if (jobSeeker != null) {
                String coverLetterPath = saveFile(coverLetterFile, "coverLetter");
                jobSeeker.setCoverLetterPath(coverLetterPath);
                jobSeekerService.update(jobSeeker);
                return "Cover letter uploaded successfully";
            } else {
                return "JobSeeker not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred during file upload.";
        }
    }

    @GetMapping("/cover-letter/{fileName}")
    public ResponseEntity<Resource> downloadCoverLetter(@PathVariable String fileName) throws IOException {
        return getCover(fileName);
    }
    private ResponseEntity<Resource> getCover(String fileName) throws IOException {
        String uploadDirectory = "/uploads/coverLetter/";
        String filePath = uploadDirectory + fileName;
        Resource resource = new UrlResource(Paths.get(filePath).toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/upload/profile")
    public String uploadProfilePicture(@RequestParam("file") MultipartFile profilePictureFile,
                                       @RequestParam("jobSeekerId") int jobSeekerId) {
        try {
            JobSeeker jobSeeker = jobSeekerService.getOne(jobSeekerId);
            if (jobSeeker != null) {
                String profilePicturePath = saveFile(profilePictureFile, "profilePicture");
                jobSeeker.setProfilePicturePath(profilePicturePath);
                jobSeekerService.update(jobSeeker);
                return "Profile picture uploaded successfully";
            } else {
                return "JobSeeker not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred during file upload.";
        }
    }
    @GetMapping("/profile-picture/{fileName}")
    public ResponseEntity<Resource> downloadProfilePicture(@PathVariable String fileName) throws IOException {
        System.out.println(fileName);
        return getDp(fileName);
    }

    private ResponseEntity<Resource> getDp(String fileName) throws IOException {
        String uploadDirectory = "/uploads/profilePicture/";
        String filePath = uploadDirectory + fileName;
        Resource resource = new UrlResource(Paths.get(filePath).toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String saveFile(MultipartFile file, String directoryName) throws IOException {

        String uploadDirectory = "/uploads/";


        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String originalFileName = file.getOriginalFilename();

        String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;


        String filePath = uploadDirectory + directoryName + "/" + uniqueFileName;
        File dest = new File(filePath);
        file.transferTo(dest);

        return uniqueFileName;
    }


}
