package borzfele.miniuser.service;

import borzfele.miniuser.model.User;
import borzfele.miniuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
