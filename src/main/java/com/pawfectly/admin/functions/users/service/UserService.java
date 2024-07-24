package com.pawfectly.admin.functions.users.service;

import com.pawfectly.admin.functions.users.dto.UserRequestDto;
import com.pawfectly.admin.functions.users.repository.UserRepository;
import com.pawfectly.common.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * Retrieves a list of all {@link UserModel} entities from the repository.
     * This method interacts with the {@link UserRepository} to fetch all user records
     * stored in the database. It returns a list containing all the users, which may be
     * empty if no users are found.
     *
     * @return a {@link List} of {@link UserModel} objects representing all users in the
     *         repository. The list may be empty but will never be null.
     */
    List<UserModel> getAll();

    /**
     * Creates a new user with the provided information.
     *
     * @param request the user information request DTO containing the details for the new user
     * @return the saved UserModel object
     */
    UserModel create(UserRequestDto requestDto);

    UserModel update(Long id, UserRequestDto requestDto);
}
