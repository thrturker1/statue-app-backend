package com.statusApp.statue.service.concretes;

import com.statusApp.statue.entity.User;
import com.statusApp.statue.repository.UserRepository;
import com.statusApp.statue.service.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getOneUser(long id) {
        User detectedUser;
        detectedUser = userRepository.findById(id).orElseThrow();
        return detectedUser;
    }

    @Override
    public User postOneUser(User user) {
        if(user == null){
            System.err.println("there is no user!");
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User putOneUser(User user, long id) {
        if(userRepository.findById(id).isEmpty() || user == null) {
            System.err.println("there is no user in id or body is empty!");
            return null;
        }
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    @Override
    public void deleteOneUser(long id) {
        userRepository.deleteById(id);
    }
}
