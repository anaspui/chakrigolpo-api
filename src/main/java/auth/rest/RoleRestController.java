package auth.rest;

import auth.domain.Role;
import auth.domain.User;
import auth.service.RoleService;
import auth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleRestController {

    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @PostMapping
    public String createUser(@RequestBody Role role) {
        roleService.create(role);
        return "Successful";
    }

}