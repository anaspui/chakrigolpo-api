package candidate.controller;

import candidate.domain.JobApplication;
import candidate.service.JobApplicationService;
import company.domain.CompanyJobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/candidate/application")
public class JobApplicationRestController {
    private final JobApplicationService jobApplicationService;
    @Autowired
    public JobApplicationRestController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> addJob(@Valid @RequestBody JobApplication jobApplication, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorResponse.toString());
        }
        try {
        Object newApplication= jobApplicationService.create(jobApplication);
        return ResponseEntity.ok("New Application: " + newApplication.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
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
        try {
            this.jobApplicationService.delete(id);
            return "Deleted";
        }catch (Exception e){
            return "Something Went Wrong";
        }
    }

    @PutMapping
    public String updateApplication(@Valid @RequestBody JobApplication application, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));

            return "Invalid Request: "+ errorResponse;
        }
        try {
        this.jobApplicationService.update(application);
        return "updated";
        } catch (Exception e) {
            return "Error Updating Application";
        }
    }
}
