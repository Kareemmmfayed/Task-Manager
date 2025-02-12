package com.learning.task_manager.service;

import com.learning.task_manager.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<AppUser> getUsers();

    public AppUser getOneUser(Long theId);

    public void deleteUser(Long theId);
}
