package candidate.controller;

import auth.domain.User;
import auth.service.UserService;
import candidate.domain.JobSeeker;
import candidate.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSeekerRestController {

    @Autowired
    private final JobSeekerService jobSeekerService;
    @Autowired
    private final UserService userService;


    public JobSeekerRestController(JobSeekerService jobSeekerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.userService = userService;
    }

    @GetMapping("/jobseeker/{id}")
    public ResponseEntity<JobSeeker> getUserById(@PathVariable int id) {
        JobSeeker user = jobSeekerService.findbyId(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
