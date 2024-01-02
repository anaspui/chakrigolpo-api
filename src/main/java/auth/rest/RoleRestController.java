package auth.rest;

import auth.domain.Role;
import auth.domain.User;
import auth.service.RoleService;
import auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @PostMapping
    public String createUser(@Valid @RequestBody Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));

            return "Invalid Request: "+ errorResponse;
        }
        try {
        roleService.create(role);
        return "Successful";
        } catch (Exception e) {
            return "Error Updating User";
        }
    }

}