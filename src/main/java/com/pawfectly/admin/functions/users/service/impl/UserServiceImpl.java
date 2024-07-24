package com.pawfectly.admin.functions.users.service.impl;

import com.pawfectly.admin.functions.users.repository.UserRepository;
import com.pawfectly.admin.functions.users.service.UserService;
import com.pawfectly.common.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of all {@link UserModel} entities from the repository.
     * This method interacts with the {@link UserRepository} to fetch all user records
     * stored in the database. It returns a list containing all the users, which may be
     * empty if no users are found.
     *
     * @return a {@link List} of {@link UserModel} objects representing all users in the
     *         repository. The list may be empty but will never be null.
     */
    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }
}
