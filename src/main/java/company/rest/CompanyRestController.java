package company.rest;

import candidate.domain.JobSeeker;
import candidate.service.JobSeekerService;
import company.domain.Company;
import company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyService companyService;
    private final JobSeekerService jobSeekerService;

    @Autowired
    public CompanyRestController(CompanyService companyService, JobSeekerService jobSeekerService) {
        this.companyService = companyService;
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@Valid @RequestBody Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorResponse.toString());
        }

        try {
        Object newCompany= companyService.create(company);
        return ResponseEntity.ok("Company: " + newCompany.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
//Mapping error
//    @GetMapping("/all")
//    public ResponseEntity<Map<String, List<?>>> getAllComapny() {
//        List<Company> companies = companyService.getAll();
//
//        Map<String, List<?>> response = new HashMap<>();
//        response.put("Company", companies);
//
//        return ResponseEntity.ok(response);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable int id) {
        Company company = companyService.findById(id);

        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteCompany(@PathVariable("id") int id){
        this.companyService.delete(id);

        return "Deleted";
    }
    @GetMapping("viewCandidate/{id}")
    public JobSeeker getJob(@PathVariable("id") int id){
        return this.jobSeekerService.getOne(id);
    }

}
