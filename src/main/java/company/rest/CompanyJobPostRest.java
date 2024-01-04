package company.rest;

import candidate.domain.JobSeeker;
import candidate.service.JobSeekerService;
import company.domain.CompanyJobPost;
import company.service.CompanyJobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/company/job-post")
public class CompanyJobPostRest {

    private final CompanyJobPostService companyJobPostService;


    @Autowired
    public CompanyJobPostRest(CompanyJobPostService companyJobPostService) {
        this.companyJobPostService = companyJobPostService;


    }

    @GetMapping
    public List<CompanyJobPost> getall() {
        return companyJobPostService.getAll();

    }

    @PostMapping("/add")
    public ResponseEntity<String> addJob(@Valid @RequestBody CompanyJobPost companyJobPost, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorResponse.toString());
        }
        try {
            Object newJob = companyJobPostService.create(companyJobPost);
            return ResponseEntity.ok("New Job: " + newJob.toString());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyJobPost> getById(@PathVariable int id) {
        CompanyJobPost job = companyJobPostService.findById(id);

        if (job != null) {
            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public String deleteJob(@PathVariable("id") int id){
        this.companyJobPostService.delete(id);
        return "Deleted";
    }

    @PutMapping
    public String updateJob(@Valid @RequestBody CompanyJobPost post, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));
            return "Error: "+ errorResponse;
        }
        try{
            this.companyJobPostService.update(post);
            return "updated";
        }catch (Exception e)
        {
            return "An Error Occurred";
        }
    }


}
