package com.statusApp.statue.service.abstracts;

import com.statusApp.statue.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getOneUser(long id);
    public User postOneUser(User user);
    public User putOneUser(User user, long id);
    public void deleteOneUser(long id);
}
