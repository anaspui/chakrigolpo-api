package candidate.controller;

import candidate.domain.JobApplication;
import candidate.service.JobApplicationService;
import company.domain.CompanyJobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate/application")
public class JobApplicationRestController {
    private final JobApplicationService jobApplicationService;
    @Autowired
    public JobApplicationRestController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> addJob(@RequestBody JobApplication jobApplication) {
        Object newApplication= jobApplicationService.create(jobApplication);
        return ResponseEntity.ok("New Application: " + newApplication.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable int id) {
        JobApplication application = jobApplicationService.findById(id);

        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteApplication(@PathVariable("id") int id){
        this.jobApplicationService.delete(id);
        return "Deleted";
    }

    @PutMapping
    public String updateApplication(JobApplication application){
        this.jobApplicationService.update(application);
        return "updated";
    }
}
