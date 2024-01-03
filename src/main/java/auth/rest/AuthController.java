package auth.rest;



import auth.domain.User;
import auth.service.RoleService;
import auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final RoleService roleService;

    public AuthController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));
            return ResponseEntity.badRequest().body(errorResponse.toString());
        }
        try {
            Object newUser = userService.create(user);
            return ResponseEntity.ok("UserId: " + newUser.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

    @GetMapping("/secured")
    public String securedEndpoint() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return username;
    }


    @GetMapping("/users")
    public ResponseEntity<Map<String, List<?>>> getAllUsers() {
        List<User> users = userService.getAll();

        Map<String, List<?>> response = new HashMap<>();
        response.put("users", users);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/users")
    public String updateUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errorResponse = new StringBuilder("Validation error(s): ");
            bindingResult.getAllErrors().forEach(error -> errorResponse.append(error.getDefaultMessage()).append("; "));

            return "Invalid Request: "+ errorResponse;
        }
        try {
           userService.updateUser(user);
            return "User Updated Successfully";
        } catch (Exception e) {
            return "Error Updating User";
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        this.userService.delete(id);
        return "User Removed";
    }
    //dep
//    @GetMapping("/getUser/{username}")
//    public ResponseEntity<String> getUserData(@PathVariable String username) {
//        // Assuming userService.getUserByUsername returns the user data based on the username
//        Object userData = userService.getUserByUsername(username);
//
//        if (userData != null) {
//            // If user data is found, return it with a 200 OK status
//            return ResponseEntity.ok("User data: " + userData.toString());
//        } else {
//            // If user data is not found, return a 404 Not Found status
//            return ResponseEntity.notFound().build();
//        }
//    }
}
