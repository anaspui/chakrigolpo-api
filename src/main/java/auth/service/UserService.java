package auth.service;

import auth.domain.User;
import auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserService{


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Object create(User user) {
        return userRepository.create(user);
    }


    public User findById(int userId) {
        return userRepository.findById(userId);
    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<User> getAll() {
        return userRepository.getAll();
    }


}
