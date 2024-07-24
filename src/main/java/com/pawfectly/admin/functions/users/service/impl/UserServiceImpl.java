package com.pawfectly.admin.functions.users.service.impl;

import com.pawfectly.admin.functions.users.dto.UserRequestDto;
import com.pawfectly.admin.functions.users.repository.UserRepository;
import com.pawfectly.admin.functions.users.service.UserService;
import com.pawfectly.common.model.UserInfoModel;
import com.pawfectly.common.model.UserModel;
import org.springframework.beans.BeanUtils;
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

    /**
     * Creates a new user with the provided information.
     *
     * @param requestDto the user information request DTO containing the details for the new user
     * @return the saved UserModel object
     */
    @Override
    public UserModel create(UserRequestDto requestDto) {
        UserInfoModel userInfoModel = UserInfoModel.builder()
                .firstName(requestDto.getFirstName())
                .middleName(requestDto.getMiddleName())
                .lastName(requestDto.getLastName())
                .address(requestDto.getAddress())
                .build();

        UserModel userModel = UserModel.builder()
                .email(requestDto.getEmail())
                .mobileNo(requestDto.getMobileNo())
                .password(requestDto.getPassword())
                .isAccountLock(false)
                .userInfo(userInfoModel)
                .build();

        userInfoModel.setUser(userModel);

        return userRepository.save(userModel);
    }

    /**
     * Updates an existing user with the provided information.
     *
     * @param id the ID of the user to update
     * @param requestDto the user information request DTO containing the updated details
     * @return the updated UserModel object
     * @throws RuntimeException if the user with the specified ID is not found
     */
    @Override
    public UserModel update(Long id, UserRequestDto requestDto) {
        // TODO:: add custom error message
        UserModel findUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserInfoModel userInfoModel = new UserInfoModel();
        BeanUtils.copyProperties(requestDto, userInfoModel);
        userInfoModel.setId(findUser.getUserInfo().getId());

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(requestDto, userModel);
        userModel.setId(findUser.getId());
        userModel.setUserInfo(userInfoModel);

        userInfoModel.setUser(userModel);

        return userRepository.save(userModel);
    }
}
