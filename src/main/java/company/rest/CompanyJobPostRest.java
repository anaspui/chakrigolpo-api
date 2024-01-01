package company.rest;

import company.domain.Company;
import company.domain.CompanyJobPost;
import company.service.CompanyJobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/job-post")
public class CompanyJobPostRest {

    private final CompanyJobPostService companyJobPostService;
    @Autowired
    public CompanyJobPostRest(CompanyJobPostService companyJobPostService) {
        this.companyJobPostService = companyJobPostService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addJob(@RequestBody CompanyJobPost companyJobPost) {
        Object newJob= companyJobPostService.create(companyJobPost);
        return ResponseEntity.ok("New Job: " + newJob.toString());
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
    public String updateJob(CompanyJobPost post){
    this.companyJobPostService.update(post);
    return "updated";
    }
}
